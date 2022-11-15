package bus.busReservation.domain;

import com.sun.istack.NotNull;
<<<<<<< HEAD
import lombok.*;
=======
import lombok.Getter;
import lombok.NonNull;
>>>>>>> c61f138a9fb6dfc611b3b18d2ba520017df5cc7b

import javax.persistence.*;

@Entity
@Getter
public class Bus {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bus_id")
    private Long id;

    @Column(nullable = false)
    private String name;

<<<<<<< HEAD
    @Column(name="정류장개수",nullable = false)
    private Integer cnt;

=======
    @Column(name = "정류장개수", nullable = false)
    private Integer cnt;//정류장 개수
>>>>>>> c61f138a9fb6dfc611b3b18d2ba520017df5cc7b
}
