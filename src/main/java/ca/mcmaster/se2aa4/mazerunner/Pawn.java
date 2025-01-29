package ca.mcmaster.se2aa4.mazerunner;

public class Pawn {

    private Pos pos;
    private Pos dir;

    public Pawn(int startX, int startY, int startDir) {
        pos = new Pos(startX, startY);
        dir = new Pos(startDir, 0);
    }

    public Pawn(Pos pos, int startDir) {
        this.pos = pos;
        dir = new Pos(startDir, 0);
    }

    public void move() {
        pos = this.getNextPos();
    }

    public void turnRight() {
        int x = -dir.y();
        int y = dir.x();

        dir = new Pos(x, y);
    }

    public void turnLeft() {
        int x = dir.y();
        int y = -dir.x();

        dir = new Pos(x, y);
    }

    public void turnAround() {
        int x = -dir.x();
        int y = -dir.y();

        dir = new Pos(x, y);
    }

    public Pos getPos() {
        return pos;
    }

    public Pos getNextPos() {
        return new Pos(pos.x() + dir.x(), pos.y() + dir.y());
    }

}
