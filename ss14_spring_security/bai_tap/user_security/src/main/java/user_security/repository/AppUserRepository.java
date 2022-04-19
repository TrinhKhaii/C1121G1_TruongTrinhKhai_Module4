package user_security.repository;
/*
    Created by Trinh Khai
    Date: 19/04/2022
    Time: 13:43
*/

import org.springframework.data.jpa.repository.JpaRepository;
import user_security.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String userName);
}
