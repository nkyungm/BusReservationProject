package bus.busReservation.repository;

import bus.busReservation.domain.Reservation;
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
public class ReservationRepository {

    private final EntityManager em;
    //버스 정류장으로 조회
    public List<Timetable> findByBusStopName(String name) {
        return em.createQuery("select t from Timetable t "+
                        "join t.busStop s" +
                        " where s.name like concat('%',:name,'%') " +
                        "and t.time>= date_format(now(),'%H:%i:%s') "+
                        "group by t.bus.name,s.name order by t.time asc", Timetable.class)
                .setParameter("name", name)
                .getResultList();
    }

    //예약 정보 저장
    public void save(Reservation reservation) {
        em.persist(reservation);
    }

    //현재 시간 이전의 timetable 찾기
    public List<Timetable> findByTime(){
        return em.createQuery("select t from Timetable t "+
                        " where t.time < date_format(now(),'%H:%i:%s') ", Timetable.class)
                .getResultList();
    }
}
