package data;

public class Floor {

    int floorNum;
    boolean hasCalledLift;

    // can be skipped if Direction
    // is down by default (one button)
    Button button;

    // OR both buttons are pressed
    // Set<Direction> directions;

    public Floor(int floorNum) {
        this.floorNum = floorNum;
        this.hasCalledLift = true;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public void disengageFloor() {
        this.hasCalledLift = false;
    }
}
