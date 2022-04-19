package user_security.repository;
/*
    Created by Trinh Khai
    Date: 19/04/2022
    Time: 13:46
*/

import org.springframework.data.jpa.repository.JpaRepository;
import user_security.entity.AppUser;
import user_security.entity.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole> findByAppUser(AppUser appUser);
}
