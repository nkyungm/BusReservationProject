package bus.busReservation.domain;

import javax.persistence.*;

@Entity
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private boolean status;

    @OneToOne
    @JoinColumn(name = "승차정보", nullable = false)
    private Timetable onInfo;

    @OneToOne
    @JoinColumn(name = "하차정보", nullable = false)
    private Timetable offInfo;
}
