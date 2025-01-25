package ca.mcmaster.se2aa4.mazerunner;

public class PathGenerator {
    private Pawn player;
    private Maze maze;

    public PathGenerator(String filepath) {
        // Parse filepath data and create the maze and player
        maze = new Maze(filepath);
        maze.printMaze();

        player = new Pawn(maze.getStart());
    }

    public String findPath() {
        String path = "";

        // this will only loop until the end of the maze when travelling in a straight line
        for (int i=0;i < maze.getWidth() - 1;i++) {
             if (player.move(maze)) path += "F";
        }
        return path;
    }

    public boolean atEnd() {
        return (player.getPos().equals(maze.getEnd()));
    }
}
