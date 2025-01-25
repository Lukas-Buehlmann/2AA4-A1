package ca.mcmaster.se2aa4.mazerunner;

public class PathGenerator {
    private Pawn player;
    private Maze maze;

    public PathGenerator(String filepath) {
        // Parse filepath data and create the maze and player
        maze = new Maze(filepath);
        maze.printMaze();
        // TODO
    }

    public boolean hasWon() {
        // TODO
        return false;
    }
}
