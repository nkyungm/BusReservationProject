package bus.busReservation.repository;

import bus.busReservation.domain.Bus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BusRepository {
    private final EntityManager em;

    //저장된 버스 모두 찾기
    public List<Bus> findAll(){
        return em.createQuery("select b from Bus b", Bus.class)
                .getResultList();
    }
}
