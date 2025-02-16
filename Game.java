import java.util.List;

public class Game {
    private int nbOfFood;
    private int nbOfObstacles;
    private Map map;
    private Snake snake;
    private List<Cell> activeItems;
    private char input;


    public Game(Map map, Snake snake) {
        this.nbOfFood = map.getHeight() * map.getWidth() / 10;
        this.nbOfObstacles = map.getHeight() * map.getWidth() / 10;
        this.map = map;
        this.snake = snake;
        for(int i = 0; i < nbOfFood + nbOfObstacles; i++) {
            int x, y;
            Cell cell;
            do {
                x = (int) (Math.random() * map.getWidth());
                y = (int) (Math.random() * map.getHeight());
            } while (map.cellNotEmpty(x, y));
            
            if (i < nbOfFood) {
                cell = new Food(x, y);
            } else {
                cell = new Obstacle(x, y);
            }
            activeItems.add(cell);
            map.setCell(cell);
        }
    }

    public void play() {
        // TODO: expect input (keyboard setup) 
        
        // decide what to do
    }
    
    public void checkCollision(char input) { 
        // delay in x and y position
        // update hypothetical position first then check for collision
        int x_tmp = snake.getBody().get(0).getX();
        int y_tmp = snake.getBody().get(0).getY();
        switch (input) {
            case Direction.UP: y_tmp++; break;
            case Direction.DOWN: y_tmp--; break;
            case Direction.LEFT: x_tmp--; break;
            case Direction.RIGHT: x_tmp++; break;
            default: break;
        }
        Cell cell_tmp = new SnakeHead(x_tmp, y_tmp); // temporary cell to check potential collision

        if (cell_tmp.getX() < 0 || cell_tmp.getX() >= map.getWidth() || cell_tmp.getY() < 0 || cell_tmp.getY() >= map.getHeight()) {
            endGame(false); // if snake hits wall, end game
        } else if ( (snake.getDirection() == Direction.UP && input == Direction.DOWN) || 
                    (snake.getDirection() == Direction.DOWN && input == Direction.UP) || 
                    (snake.getDirection() == Direction.LEFT && input == Direction.RIGHT) || 
                    (snake.getDirection() == Direction.RIGHT && input == Direction.LEFT)) {
                        endGame(false); // if snake hits itself, end game
                    } else if (map.getCellType(x_tmp, y_tmp) == SnakeBodyCell.class.getName()) {
                        endGame(false); // if snake hits itself, end game
                    }
                    else if(map.getCellType(x_tmp, y_tmp).equals(EmptyCell.class.getName())){
                        snake.move(input); // if snake moves to empty cell, move
                        map.setCell(new SnakeHead(x_tmp, y_tmp));
                        map.setCell(new SnakeBodyCell(
                                        snake.getBody().get(1).getX(),
                                        snake.getBody().get(1).getY()
                                        ));
                        map.setCell(new EmptyCell(snake.getBody().get(snake.getBody().size() - 1).getX(),
                                                    snake.getBody().get(snake.getBody().size() - 1).getY()));
                    } 
                    else {

                        for (Cell cell : activeItems) {
                            if (cell_tmp.checkOverlap(cell)) {
                                if (cell.getClass() == Food.class) {
                                    snake.grow(input); // if snake eats food, grow
                                    activeItems.remove(cell);
                                    map.setCell(new SnakeHead(cell.getX(), cell.getY()));
                                    map.setCell(new SnakeBodyCell(
                                        snake.getBody().get(1).getX(),
                                        snake.getBody().get(1).getY()
                                        ));
                                } else {
                                    endGame(false); // if snake hits obstacle, end game
                                }
                            }
                        }
                    }
    }

    public String endGame(boolean state){
        if(state){
            return "You win!";
        } else {
            return "You lose!";
        }
    }

    public void handleInput(char input) {
        // add input - keypad functionality
        }
    }

