package bus.busReservation.service;

import bus.busReservation.domain.Reservation;
import bus.busReservation.domain.Timetable;
import bus.busReservation.domain.User;
import bus.busReservation.dto.TimetableDto;
import bus.busReservation.repository.ReservationRepository;
import bus.busReservation.repository.TimeTableRepository;
import bus.busReservation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final TimeTableRepository timeTableRepository;
    private final UserRepository userRepository;
    private final BusService busService;

    public List<TimetableDto> findByBusStopName(String keyword){
        List<Timetable> timetables=reservationRepository.findByBusStopName(keyword);

        List<TimetableDto> timetableDtoList=timetables.stream()
                .map(t-> new TimetableDto(t))
                .collect(Collectors.toList());

        if(timetables.isEmpty()) return timetableDtoList;

        return timetableDtoList;
    }

    //저장
    @Transactional
    public Long saveReservation(Long userId, Long onInfoId, Long offInfoId){
        User user = userRepository.findById(userId);//사용자 정보 생성

        Timetable  onInfo = timeTableRepository.findById(onInfoId);//출발지 정보 생성
        Timetable offInfo = timeTableRepository.findById(offInfoId);//도착지 정보 생성

        Reservation reservation = Reservation.createReservation(user, onInfo, offInfo);//예약 생성
        reservationRepository.save(reservation);//예약 저장

        return reservation.getId();
    }
}
