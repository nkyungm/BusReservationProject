package bus.busReservation.service;

import bus.busReservation.domain.Bus;
import bus.busReservation.domain.Timetable;
import bus.busReservation.repository.BusRepository;
import bus.busReservation.repository.TimeTableRepository;
import bus.busReservation.route.One;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TimeTableService {

    private final TimeTableRepository timeTableRepository;
    private final BusRepository busRepository;
    private final BusService busService;

    //버스 이름 별
    public List<Timetable> findTimetable(String name){
        return timeTableRepository.findByBusName(name);
    }

    public List<Timetable> findAll(){
        return timeTableRepository.findAll();
    }
}
