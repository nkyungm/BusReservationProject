package bus.busReservation.domain;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
public class Timetable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Time time;

    @Column(nullable = false)
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "bus_stop_id", nullable = false)
    private BusStop busStop;

    @ManyToOne
    @JoinColumn(name = "bus_id", nullable = false)
    private Bus bus;
}
