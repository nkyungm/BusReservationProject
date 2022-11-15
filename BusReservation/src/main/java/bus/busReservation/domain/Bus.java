package bus.busReservation.domain;

import com.sun.istack.NotNull;
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

    @Column(name = "정류장개수", nullable = false)
    private Integer cnt;//정류장 개수
}
