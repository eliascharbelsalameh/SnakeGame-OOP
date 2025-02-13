import java.util.List;

public class Game {
    private int nbOfFood;
    private int nbOfObstacles;
    private Map map;
    private Snake snake;
    private List<Cell> activeItems;

    public void handleInput(char input) {
        switch (input) {
            case Direction.UP:
                snake.setDirection(Direction.UP);
                break;
            case Direction.DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case Direction.LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case Direction.RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
        }
    }

    public void startGame() {

        }

    public void endGame() {

    }
}
