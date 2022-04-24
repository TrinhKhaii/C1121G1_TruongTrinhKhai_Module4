package furama.repository.user_repository;
/*
    Created by Trinh Khai
    Date: 24/04/2022
    Time: 14:16
*/

import furama.model.user_role_entity.User;
import furama.model.user_role_entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByUser(User user);
}
