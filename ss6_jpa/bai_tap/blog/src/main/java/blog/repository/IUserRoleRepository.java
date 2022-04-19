package blog.repository;
/*
    Created by Trinh Khai
    Date: 19/04/2022
    Time: 18:06
*/

import blog.model.User;
import blog.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByUser(User user);
}
