package bus.busReservation;

import bus.busReservation.domain.Timetable;
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
    public void  버스_시간표_조회() throws Exception {
        //given
        List<Timetable> timetableList = timeTableService.findTimetable("100");

        System.out.println(timetableList.size());
    }
}
