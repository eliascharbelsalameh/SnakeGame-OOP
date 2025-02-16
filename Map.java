public class Map {
    private final int height;
    private final int width;
    private final Cell[][] grid;
    
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[height][width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new EmptyCell(i, j);
            }
        }
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setCell(Cell cell) {
        grid[cell.getX()][cell.getY()] = cell;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public boolean cellNotEmpty(int x, int y) {
        return grid[x][y].getClass() != EmptyCell.class;
    }

    public String getCellType(int x, int y) {
        return grid[x][y].getClass().getName();
    }

    @Override
    public String toString() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        return "";
    }
}
