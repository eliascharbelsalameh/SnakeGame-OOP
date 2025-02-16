import java.util.List;

public class Snake {
    private List<Cell> body;
    private char direction;

    public Snake(List<Cell> body, char direction) {
        this.body = body;
        this.direction = direction;
    }

    public List<Cell> getBody() {
        return body;
    }

    public void setBody(List<Cell> body) {
        this.body = body;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    
    public void move(char input) {

    }
    public void grow(char input) {
        
    }
}
