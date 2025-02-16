import java.util.List;

public class Game {
    private int nbOfFood;
    private int nbOfObstacles;
    private Map map;
    private Snake snake;
    private List<Cell> activeItems;


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
    public void checkCollision() {
        for (Cell cell : activeItems) {
            if (snake.getBody().get(0).checkOverlap(cell)) {
                if (cell.getClass() == Food.class) {
                    // snake.grow(); // to complete
                    activeItems.remove(cell);
                    map.setCell(new SnakeHead(cell.getX(), cell.getY()));
                    map.setCell(new SnakeBodyCell(
                        snake.getBody().get(1).getX(),
                        snake.getBody().get(1).getY()
                        )
                        );
                } else {
                    endGame(false);
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
        snake.move(input);
        }
    }

