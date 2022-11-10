package bus.busReservation.domain;

import javax.persistence.*;

@Entity
public class BusStop {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_stop_id")
    private Long id;

    @Column(nullable = false)
    private String name;
}
