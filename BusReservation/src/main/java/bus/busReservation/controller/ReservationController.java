package bus.busReservation.controller;

import bus.busReservation.domain.Timetable;
import bus.busReservation.domain.User;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.repository.TimeTableRepository;
import bus.busReservation.repository.UserRepository;
import bus.busReservation.service.ReservationService;
import bus.busReservation.service.TimeTableService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;
    private final TimeTableService timeTableService;
    private final TimeTableRepository timeTableRepository;
    private final UserRepository userRepository;

    @RequestMapping("/reservation")
    public String res(){
        return "reservation/reservationList";
    }

    @RequestMapping("/reservation/search")
    public String reservation(@RequestParam(value="keyword") String keyword,Model model){
        timeTableService.falseStatus();//현재시간 이전의 예약된 좌석들을 다시 빈좌석으로 변경
        
        List<TimetableDto> timetableDtoList=reservationService.findByBusStopName(keyword);
        model.addAttribute("timetableList",timetableDtoList);

        return "reservation/reservationList";
    }

    //예약-도착지 선택하는 부분
    @GetMapping("/reservation/{id}/{busName}")
    public String destination(@PathVariable("id") Long id, @PathVariable("busName") String busName, Model model ){
        Timetable start = timeTableRepository.findById(id);
        List<TimetableDto> destinationDtoList = timeTableService.destination(busName, id);

        model.addAttribute("start", start);
        model.addAttribute("timetableList", destinationDtoList);

        return "reservation/destination";
    }

   /*
   * 예약완료
   */
    @GetMapping("/complete/{start_id}/{end_id}")
    public String completeReservation(@PathVariable("start_id") Long start_id, @PathVariable("end_id") Long end_id, Model model ){

        Timetable start = timeTableRepository.findById(start_id);
        Timetable end = timeTableRepository.findById(end_id);

        reservationService.saveReservation(1234L, start_id, end_id);//reservation table 에 예약 정보 저장
        timeTableService.trueStatus(start_id, end_id);//timetable 의 예약 상태가 출발지~도착지까지 true 로 변경 됨

        model.addAttribute("start", start);
        model.addAttribute("end", end);

        return "reservation/complete";
    }
}
