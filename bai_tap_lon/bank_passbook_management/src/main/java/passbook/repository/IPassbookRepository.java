package passbook.repository;
/*
    Created by Trinh Khai
    Date: 08/04/2022
    Time: 08:57
*/

import org.springframework.data.jpa.repository.JpaRepository;
import passbook.model.Passbook;

public interface IPassbookRepository extends JpaRepository<Passbook, Integer> {
}
