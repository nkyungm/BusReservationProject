package bus.busReservation.controller;

import bus.busReservation.dto.TimetableDto;
import bus.busReservation.service.ReservationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservationController {
    private ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService=reservationService;
    }

    @RequestMapping("/reservation")
    public String res(){
        return "/reservation/reservationList";
    }

    @RequestMapping("/reservation/search")
    public String reservation(@RequestParam(value="keyword") String keyword,Model model){
        List<TimetableDto> timetableDtoList=reservationService.findByBusStopName(keyword);
        model.addAttribute("timetableList",timetableDtoList);
        return "/reservation/reservationList";
    }

}
