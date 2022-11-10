package bus.busReservation.domain;

import com.sun.istack.NotNull;
import lombok.NonNull;

import javax.persistence.*;

@Entity
public class Bus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(nullable = false)
    private String name;
}
