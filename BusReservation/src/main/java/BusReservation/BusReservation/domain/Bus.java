package BusReservation.BusReservation.domain;

import com.sun.istack.NotNull;
import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Bus {
    @Id
    @Column(name = "bus_id")
    private Long id;

    @Column(nullable = false)
    private String name;
}
