import java.util.List;

public class Snake {
    private List<Cell> body;
    private int length;
    private char direction;

    public Snake(List<Cell> body, int length, char direction) {
        this.body = body;
        this.length = length;
        this.direction = direction;
    }

    public List<Cell> getBody() {
        return body;
    }

    public void setBody(List<Cell> body) {
        this.body = body;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    //TODO: CHECK IF ACCURATE
    public void move() {
        Cell head = body.get(0);
        int x = head.getX();
        int y = head.getY();
        switch (direction) {
            case Direction.UP:
                y--;
                break;
            case Direction.DOWN:
                y++;
                break;
            case Direction.LEFT:
                x--;
                break;
            case Direction.RIGHT:
                x++;
                break;
        }
        Cell newHead = new EmptyCell(x, y);
        body.add(0, newHead);
        if (body.size() > length) {
            body.remove(body.size() - 1);
        }
    }

    public void grow() {
        Cell tail = body.get(body.size() - 1);
        int x = tail.getX();
        int y = tail.getY();
        switch (direction) {
            case Direction.UP:
                y++;
                break;
            case Direction.DOWN:
                y--;
                break;
            case Direction.LEFT:
                x++;
                break;
            case Direction.RIGHT:
                x--;
                break;
        }
        Cell newTail = new EmptyCell(x, y);
        body.add(newTail);
        length++;
    }
}
