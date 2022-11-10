package bus.busReservation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @Column(name ="user_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String username;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
}
