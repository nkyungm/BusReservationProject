package bus.busReservation.repository;

import bus.busReservation.domain.Timetable;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.Time;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepo {

    private final EntityManager em;
    //버스 이름으로 조회
    public List<Timetable> findByBusStopName(String name) {
        return em.createQuery("select t from Timetable t "+
                        "join t.busStop s" +
                        " where s.name like concat('%',:name,'%') " +
                        "and t.time>= date_format(now(),'%H:%i:%s') "+
                        "group by t.bus.name,s.name order by t.time asc", Timetable.class)
                .setParameter("name", name)
                .getResultList();
    }
}
