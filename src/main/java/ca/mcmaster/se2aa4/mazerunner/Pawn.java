package ca.mcmaster.se2aa4.mazerunner;

public class Pawn {
    public enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private Pos pos;
    private Dir dir;

    public Pawn(int startX, int startY) {
        pos = new Pos(startX, startY);
    }

    public Pawn(Pos pos) {
        this.pos = pos;
    }

    // function to move forward. returns true if successful
    // consider changing from a Maze here to just the cell value
    public boolean move(Maze maze) {

        // TODO use the direction
        if (maze.getCell(pos.x() + 1, pos.y()) == 0) {
            pos = new Pos(pos.x() + 1, pos.y());
            return true;
        }
        return false;
    }

    public void turnRight() {
        // TODO
    }

    public void turnLeft() {
        // TODO
    }

    public Pos getPos() {
        return pos;
    }

}
