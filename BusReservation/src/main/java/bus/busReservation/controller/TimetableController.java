package bus.busReservation.controller;

import bus.busReservation.domain.Bus;
import bus.busReservation.domain.Timetable;
import bus.busReservation.route.One;
import bus.busReservation.service.BusService;
import bus.busReservation.service.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TimetableController {
    private final TimeTableService timeTableService;
    private final BusService busService;

    @GetMapping("/timetables")
    public String timetableList(Model model){
        List<Bus> busList = busService.findAllName();//버스 이름 찾기
        model.addAttribute("busList", busList);

        return "timetable/timeList";
    }

    @GetMapping("/{busName}")
    public String oneTimetables(@PathVariable("busName") String busName,Model model){

        int c = busService.findCnt(busName);

        List<Bus> busList = busService.findAllName();//버스 이름 찾기
        List<Timetable> timetables = timeTableService.findTimetable(busName);

        model.addAttribute("c", c);
        model.addAttribute("timetables", timetables);
        model.addAttribute("busList", busList);

        return "timetable/oneTimeList";
    }
}
