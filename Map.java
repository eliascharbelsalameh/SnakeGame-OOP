public class Map {
    private int height;
    private int width;
    private Cell[][] grid;
    
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new EmptyCell(i, j);
            }
        }
    }

    public void setCell(Cell cell) {
        grid[cell.getX()][cell.getY()] = cell;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public void print() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
