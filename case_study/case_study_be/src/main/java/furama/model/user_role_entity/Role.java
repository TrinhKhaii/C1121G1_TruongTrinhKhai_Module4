package furama.model.user_role_entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 09:16
*/
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<UserRole> userRoles;
}
