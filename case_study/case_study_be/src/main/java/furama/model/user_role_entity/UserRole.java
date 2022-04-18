package furama.model.user_role_entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 09:17
*/
@Entity
@Data
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "roleId")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "userName")
    private User user;
}
