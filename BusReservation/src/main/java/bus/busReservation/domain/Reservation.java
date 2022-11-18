package bus.busReservation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

//    @Column(nullable = false)
//    private boolean status;

    @OneToOne
    @JoinColumn(name = "승차정보", nullable = false)
    private Timetable onInfo;

    @OneToOne
    @JoinColumn(name = "하차정보", nullable = false)
    private Timetable offInfo;

    //==생성 메서드==/
    public static Reservation createReservation(User user, Timetable onInfo, Timetable offInfo){
        Reservation reservation = new Reservation();

        reservation.setUser(user);
        reservation.setOnInfo(onInfo);
        reservation.setOffInfo(offInfo);

        return reservation;
    }
}
