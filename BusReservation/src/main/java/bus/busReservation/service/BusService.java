package bus.busReservation.service;

import bus.busReservation.domain.Bus;
import bus.busReservation.repository.BusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BusService {
    private final BusRepository busRepository;

    //모든 버스의 이름
    public List<Bus> findAllName(){
        return busRepository.findAll();
    }
}
