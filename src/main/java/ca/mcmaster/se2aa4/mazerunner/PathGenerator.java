package ca.mcmaster.se2aa4.mazerunner;

public class PathGenerator {
    private Pawn player;
    private Maze maze;

    public PathGenerator(String filepath) {
        // Parse filepath data and create the maze and player
        maze = new Maze(filepath);
        maze.printMaze();

        player = new Pawn(maze.getStart(), 1);
    }

    public String findPath() {
        String path = "";
        Pos next;
        int turns;
        String moves = "RFL";

        while (!this.atEnd()) {
            player.turnAround();
            turns = -1;

            do {
                turns++;
                player.turnLeft();
                next = player.getNextPos();
                // System.out.println("next - x: " + next.x() + " y: " + next.y());
            } while (maze.getCell(next.x(), next.y()) != 0 && turns <= 2);

            if (turns > 2) {
                player.turnRight();
                path += "L";
                // System.out.print("L ");
            } else {
                if (turns != 1) path += moves.charAt(turns);
                path += "F";
                // System.out.print(moves.charAt(turns) + "F ");
                player.move();
            }

        }

        return path;
    }

    public boolean atEnd() {
        return (player.getPos().equals(maze.getEnd()));
    }
}
