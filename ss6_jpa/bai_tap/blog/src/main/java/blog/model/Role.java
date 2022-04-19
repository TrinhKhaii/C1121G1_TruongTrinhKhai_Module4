package blog.model;
/*
    Created by Trinh Khai
    Date: 19/04/2022
    Time: 14:44
*/

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "ROLE_UK", columnNames = "role_name") })
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    @NotNull
    private Long roleId;

    @Column(name = "role_name", length = 30)
    @NotNull
    private String roleName;

    public Role() {
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
