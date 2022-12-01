package bus.busReservation.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
    @Id
    @Column(name ="user_id")
    private String id;

    @Column(name = "name", nullable = false)
    private String username;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;

    public String r_id(){
        return this.id;
    }

}
