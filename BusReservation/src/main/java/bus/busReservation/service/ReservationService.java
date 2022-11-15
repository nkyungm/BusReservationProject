package bus.busReservation.service;

import bus.busReservation.domain.Timetable;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.repository.ReservationRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {
    private final ReservationRepo reservationRepo;

    @Transactional
    public List<TimetableDto> findByBusStopName(String keyword){
        List<Timetable> timetables=reservationRepo.findByBusStopName(keyword);

        List<TimetableDto> timetableDtoList=timetables.stream()
                .map(t-> new TimetableDto(t))
                .collect(Collectors.toList());

        if(timetables.isEmpty()) return timetableDtoList;

        return timetableDtoList;
    }

}
