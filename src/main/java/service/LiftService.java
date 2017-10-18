package service;

import data.Floor;
import data.Lift;
import enumeration.Direction;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.PriorityQueue;

@Service
public class LiftService {

    public static final int FLOORS = 20;

    static Comparator<Floor> floorComparator = Comparator.comparing(Floor::getFloorNum);

    static PriorityQueue<Floor> requestQueueUp = new PriorityQueue<>(FLOORS, floorComparator);
    static PriorityQueue<Floor> requestQueueDown = new PriorityQueue<>(FLOORS, floorComparator.reversed());


    // the actual call

    /*
    We want to add floors as follows:

    - If the the lift is idle, serve the first call and set the direction to "DOWN" if lift location > floor request; "UP" otherwise.
    - Else, if the lift's direction is DOWN and
        - if floor request is on lift's route (meaning, lift location > floor's request if Direction is "DOWN" and vice versa) then floor is added according the comparator.
        - else, it's added at the bottom

     */
    public void callLift(Floor floor) {
        Direction liftDirection = Lift.direction;

        if (liftDirection == Direction.UP) {
            if(floor.getFloorNum() > Lift.location) { requestQueueUp.add(floor); }
            else { requestQueueDown.add(floor); }
        } else {
            if(floor.getFloorNum() < Lift.location) { requestQueueDown.add(floor); }
            else { requestQueueUp.add(floor); }
        }

        // it needs to be somewhere else...
        if (liftDirection == Direction.DOWN) {
            serveFloor(requestQueueDown, floor);
        } else {
            serveFloor(requestQueueUp, floor);
        }

        if(requestQueueUp.size() == 0 && requestQueueDown.size() == 0) {
            Lift.idle = true;
        }
    }

    private void serveFloor(PriorityQueue<Floor> requestQueue, Floor floor) {
        while (requestQueue.size() != 0) {
            // floor is served
            floor.disengageFloor();
            Lift.location = floor.getFloorNum();
            System.out.println(requestQueue.remove());
        }
    }
}
