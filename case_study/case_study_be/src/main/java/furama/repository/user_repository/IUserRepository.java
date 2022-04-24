package furama.repository.user_repository;
/*
    Created by Trinh Khai
    Date: 22/04/2022
    Time: 09:28
*/

import furama.model.user_role_entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
