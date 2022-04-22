package furama.repository.employee_repository;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 22:58
*/

import furama.model.employee_entity.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
