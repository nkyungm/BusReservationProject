package BusReservation.BusReservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BusStop {
    @Id
    @Column(name = "bus_stop_id")
    private Long id;

    @Column(nullable = false)
    private String name;
}
