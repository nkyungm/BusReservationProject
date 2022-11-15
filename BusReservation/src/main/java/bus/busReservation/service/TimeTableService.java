package bus.busReservation.service;

import bus.busReservation.domain.Timetable;
import bus.busReservation.repository.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TimeTableService {

    private final TimeTableRepository timeTableRepository;

    //버스 이름 별로 조희
    public List<Timetable> findTimetable(String name){
        return timeTableRepository.findByBusName(name);
    }

    public List<Timetable> findAll(){
        return timeTableRepository.findAll();
    }
}
