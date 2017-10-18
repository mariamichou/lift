package data;

import enumeration.Direction;

public class Button {

    //boolean pressedUp;
    boolean pressedDown;

    Button() {
        pressedDown = false;
    }

    Button(boolean pressedDown) {
        this.pressedDown = pressedDown;
    }
}
