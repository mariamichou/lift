package facade;

import data.Floor;
import enumeration.Direction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.LiftService;

import java.util.HashMap;
import java.util.Map;

@Component
public class LiftFacade {

    @Autowired
    LiftService liftService;

    public void callLift(int floorNum, Direction direction) {
        Floor floor = new Floor(floorNum);

        liftService.callLift(floor);

    }
}
