package furama.repository.employee_repository;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 22:59
*/

import furama.model.employee_entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
