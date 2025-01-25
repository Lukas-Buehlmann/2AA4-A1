package ca.mcmaster.se2aa4.mazerunner;

public class Pawn {
    private Pos pos;
    private int dir;

    public Pawn(int startX, int startY, int startDirection) {
        pos =  new Pos(startX, startY);
        dir = startDirection;
    }

    // function to move forward. returns true if successful
    public boolean move() {
        // TODO
        return true;
    }

    public void turnRight() {
        // TODO
    }

    public void turnLeft() {
        // TODO
    }

}
