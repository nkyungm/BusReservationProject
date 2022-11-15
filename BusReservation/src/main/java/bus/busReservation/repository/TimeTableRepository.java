package bus.busReservation.repository;
import bus.busReservation.domain.Timetable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TimeTableRepository {

    private final EntityManager em;
    //All 조회
    public List<Timetable> findAll(){
        return em.createQuery("select t from Timetable t", Timetable.class)
                .getResultList();
    }
    //버스 이름으로 조회
    public List<Timetable> findByBusName(String name){

        return em.createQuery("select t from Timetable t join t.bus b"
                + " where b.name like :name ", Timetable.class)
                .setParameter("name", name)
                .getResultList();
    }
}
