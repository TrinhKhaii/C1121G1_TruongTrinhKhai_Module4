package blog.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

/*
    Created by Trinh Khai
    Date: 19/04/2022
    Time: 14:38
*/
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "USER_UK", columnNames = "userName")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 36)
    @NotNull
    private Long userId;
    @Column(length = 60)
    @NotNull
    private String userName;
    @Column(length = 128)
    @NotNull
    private String encrytedPassword;

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncrytedPassword() {
        return encrytedPassword;
    }

    public void setEncrytedPassword(String encrytedPassword) {
        this.encrytedPassword = encrytedPassword;
    }
}
