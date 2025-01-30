package ca.mcmaster.se2aa4.mazerunner;

public class PathGenerator {
    private Pawn player;
    private Maze maze;

    public PathGenerator(String filepath) {
        // Parse filepath data and create the maze and player
        maze = new Maze(filepath);
        maze.printMaze();

        player = new Pawn(maze.getStart(), maze.getDirection());
    }

    public void changeGoal() {
        maze.switchDirection();
        player = new Pawn(maze.getStart(), maze.getDirection());
    }

    public Path findPath() {
        Path path = new Path();
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
            } while (maze.getCell(next.x(), next.y()) != 0 && turns <= 2);

            if (turns > 2) {
                player.turnRight();
                path.append("L");
            } else {
                if (turns != 1) path.append("" + moves.charAt(turns));
                path.append("F");
                player.move();
            }

        }

        return path;
    }

    public boolean verifyBothPaths(String path) {
        boolean success = verifyPath(path);
        if (success) return true;
        this.changeGoal();
        return verifyPath(path);
    }

    public boolean verifyPath(String path) {
        try {
            for (int i=0;i < path.length();i++) {
                switch(path.charAt(i)) {
                    case 'F':
                        player.move();
                        break;
                    case 'R':
                        player.turnRight();
                        break;
                    case 'L':
                        player.turnLeft();
                }
                if (maze.getCell(player.getPos()) != 0) return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return this.atEnd();
    }

    public boolean atEnd() {
        return (player.getPos().equals(maze.getEnd()));
    }
}
