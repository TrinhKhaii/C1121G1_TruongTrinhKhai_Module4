package furama.repository.employee_repository;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:48
*/

import furama.model.employee_entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
}
