package bus.busReservation;

import bus.busReservation.domain.Timetable;
import bus.busReservation.repository.TimeTableRepository;
import bus.busReservation.route.One;
import bus.busReservation.service.TimeTableService;
import org.assertj.core.api.Assertions;
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

}
