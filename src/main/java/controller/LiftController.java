package controller;

import enumeration.Direction;
import facade.LiftFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableAutoConfiguration
public class LiftController {

    @Autowired
    LiftFacade liftFacade;

    /* Payload should be the floor number
    * from which the request originated and
    * the direction where the user needs to go.
    * If no direction given, then Direction is assumed down
    * for residential lifts.
    * Return type could be double for the average waiting time
    * (it could be translated as audio upon pressing the button).
    * */

    @RequestMapping(value="/call/{floorNum:.+}/", method = RequestMethod.GET)
    public void callLift(@PathVariable int floorNum,
                           @RequestParam(value = "direction", required = false) Direction direction) {

        liftFacade.callLift(floorNum, direction);
    }
}
