package ca.mcmaster.se2aa4.mazerunner;

public abstract class PathGenerator {
    protected Pawn player;
    protected Maze maze;

    public PathGenerator(String filepath) {
        
        maze = new Maze(filepath);
        maze.printMaze();

        player = new Pawn(maze.getStart(), maze.getDirection());
    }

    public void changeGoal() {
        maze.switchDirection();
        player = new Pawn(maze.getStart(), maze.getDirection());
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
    
    public abstract Path findPath();
}
