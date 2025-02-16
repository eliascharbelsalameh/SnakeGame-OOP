import java.util.ArrayList;
import java.util.List;

public class driver {
    public static void main(String[] args) {
        // Map map = new Map(10, 10);
        // Snake snake = new Snake();
        // Game game = new Game(map, snake);
        // while (game.getIsOver() == "continue") {
            // System.out.println("Enter a direction (w, a, s, d): ");
            // char input = scanner.next().charAt(0);
            // game.setInput(input);
            // game.play();
        // }
        // scanner.close();
        List<Cell> body = new ArrayList<>();
        Map map = new Map(10, 10);
        body.add(0, new SnakeHead(1, 1));
        body.add(1, new SnakeBodyCell(1, 0));
        body.add(2, new SnakeBodyCell(0, 0)); 
        map.setCell(new SnakeBodyCell(0, 0));
        map.setCell(new SnakeHead(1, 1));
        map.setCell(new SnakeBodyCell(1, 0));
        Snake snake = new Snake(body, Direction.RIGHT);
        Game game = new Game(map, snake);
        game.play();
    }
}