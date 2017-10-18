package data;

import enumeration.Direction;


// final because we don't need a subclass
public final class Lift {

    public static int location;

    //if it's not moving
    public static boolean idle;

    //if it's moving, which direction?
    public static Direction direction;

    public static int getLocation() {
        return location;
    }

    public static boolean isIdle() {
        return idle;
    }

    public static Direction getDirection() {
        return direction;
    }

    //...

}
