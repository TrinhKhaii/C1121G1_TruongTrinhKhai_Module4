package furama.model.user_role_entity;

import furama.model.employee_entity.Employee;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 09:15
*/
@Entity
@Data
public class User {
    @Id
    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    private Set<UserRole> userRoles;

    @OneToMany(mappedBy = "user")
    private Set<Employee> employees;
}
