package blog.repository;
/*
    Created by Trinh Khai
    Date: 19/04/2022
    Time: 18:04
*/

import blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}
