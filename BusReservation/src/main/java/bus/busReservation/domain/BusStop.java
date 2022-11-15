package bus.busReservation.domain;

<<<<<<< HEAD
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> c61f138a9fb6dfc611b3b18d2ba520017df5cc7b

import javax.persistence.*;

@Entity
<<<<<<< HEAD
@Getter
=======
@Getter @Setter
>>>>>>> c61f138a9fb6dfc611b3b18d2ba520017df5cc7b
public class BusStop {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_stop_id")
    private Long id;

    @Column(nullable = false)
    private String name;



}
