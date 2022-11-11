package bus.busReservation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimetableController {
    @RequestMapping("/timetable")
    public String timetable(){
        return "timetable/timeList";
    }
}
