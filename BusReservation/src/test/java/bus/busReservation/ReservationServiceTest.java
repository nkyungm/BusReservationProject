package bus.busReservation;

import bus.busReservation.domain.Timetable;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.repository.ReservationRepository;
import bus.busReservation.service.ReservationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ReservationServiceTest {

    @Autowired
    ReservationService reservationService;
    @Autowired
    ReservationRepository reservationRepository;

    @Test
    public void timetabletest() throws Exception{
        //given
        List<TimetableDto> result = reservationService.findByBusStopName("동대구역");

        System.out.println(result);
    }

    @Test
    public void 이전시간표_찾기(){
        List<Timetable> timetableList = reservationRepository.findByTime();
        for (Timetable timetable : timetableList) {
            System.out.println("timetable.getTime() = " + timetable.getTime());
        }
    }
}
