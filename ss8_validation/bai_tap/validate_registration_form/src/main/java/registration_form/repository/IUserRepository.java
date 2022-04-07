package registration_form.repository;
/*
    Created by Trinh Khai
    Date: 06/04/2022
    Time: 23:37
*/

import org.springframework.data.jpa.repository.JpaRepository;
import registration_form.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
