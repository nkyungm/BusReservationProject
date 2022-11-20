package bus.busReservation.service;

import bus.busReservation.domain.Timetable;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.repository.BusRepository;
import bus.busReservation.repository.TimeTableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //도착지 리스트
    public List<TimetableDto> destination(String busName, Long id){

        List<Timetable> list = new ArrayList<>();
        Long c = busService.findCnt(busName);//버스의 출발지
        Long next_id = id;//timetable 아이디

        Timetable destination = timeTableRepository.findById(next_id);//아이디에 해당하는 timetable
        Long cu_bus = destination.getBus().getId();//현재 버스 id

        Long busStop_id = destination.getBusStop().getId(); //정류장 id
        list.add(destination);


        while(true){
            next_id ++;
            destination = timeTableRepository.findById(next_id);
            busStop_id = destination.getBusStop().getId();
            Long next_bus = destination.getBus().getId();

            if((c == busStop_id) || (cu_bus != next_bus))
                break;

            list.add(destination);
        }

        List<TimetableDto> timetableDtoList=list.stream()
                .map(t-> new TimetableDto(t))
                .collect(Collectors.toList());

        return timetableDtoList;
    }
    //예약된 timetable의 status를 true로 변경하기
    public void changeStatus(Long start, Long end){
        Long id = start;

        while(true){
            Timetable timetable = timeTableRepository.findById(id);
            timetable.changeStatus();

            if(id == end)
                break;

            id++;
        }
    }
}
