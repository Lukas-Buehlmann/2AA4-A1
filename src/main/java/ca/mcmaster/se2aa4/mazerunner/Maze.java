package ca.mcmaster.se2aa4.mazerunner;

public class Maze {
    private int width;
    private int height;
    private int[][] grid;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new int[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCell(int x, int y) {
        return grid[y][x];
    }

    public void setCell(int x, int y, int val) {
        // handle oob case
        grid[y][x] = val;
    }
}
