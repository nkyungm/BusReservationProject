package bus.busReservation;

import bus.busReservation.domain.Timetable;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.repository.TimeTableRepository;
import bus.busReservation.service.TimeTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TimeTableServiceTest {

    @Autowired TimeTableRepository timeTableRepository;
    @Autowired TimeTableService timeTableService;

    @Test
    public void 도착지_찾기(){
        //Timetable byId = timeTableRepository.findById(127L);

        List<TimetableDto> destination = timeTableService.destination("100", 50L);

        for (TimetableDto timetableDto : destination) {
            System.out.println("timetable.getBusStop().getName() = " + timetableDto.getBusStop_name());
            //System.out.println("timetable.getBusStop().getId() = " + timetableDto.ge);
            System.out.println("timetable.getId() = " + timetableDto.getId());
        }
    }
}
