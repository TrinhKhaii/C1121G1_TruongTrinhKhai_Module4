package phone.repository;
/*
    Created by Trinh Khai
    Date: 14/04/2022
    Time: 21:57
*/

import org.springframework.data.jpa.repository.JpaRepository;
import phone.model.Phone;

public interface IPhoneRepository extends JpaRepository<Phone, Long> {
}
