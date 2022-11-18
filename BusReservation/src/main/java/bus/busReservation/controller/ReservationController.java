package bus.busReservation.controller;

import bus.busReservation.dto.TimetableDto;
import bus.busReservation.service.ReservationService;
import bus.busReservation.service.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final TimeTableService timeTableService;

    @RequestMapping("/reservation")
    public String res(){
        return "reservation/reservationList";
    }

    @RequestMapping("/reservation/search")
    public String reservation(@RequestParam(value="keyword") String keyword,Model model){
        List<TimetableDto> timetableDtoList=reservationService.findByBusStopName(keyword);
        model.addAttribute("timetableList",timetableDtoList);
        return "reservation/reservationList";
    }

    //예약
    @GetMapping("/reservation/{id}/{busName}")
    public String destination(@PathVariable("id") Long id, @PathVariable("busName") String busName, Model model ){
        List<TimetableDto> destinationDtoList = timeTableService.destination(busName, id);
        model.addAttribute("timetableList", destinationDtoList);

        return "reservation/destination";
    }
}
