package bus.busReservation.domain;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Getter
public class Bus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name="출발지",nullable = false)
    private Integer cnt;

    @Column(name = "차량번호", nullable = false)
    private String num;
}
