package furama.model.user_role_entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import furama.model.employee_entity.Employee;


import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 09:15
*/
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNameId;

    private String userName;
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private Set<UserRole> userRoles;

    @OneToOne(mappedBy = "user")
    private Employee employee;

    public User() {
    }

    public Integer getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(Integer userNameId) {
        this.userNameId = userNameId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
