package furama.repository.employee_repository;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 10:48
*/

import furama.model.employee_entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where employee.delete_flag = 0 and employee.name like concat('%',:employee_name,'%')", nativeQuery = true)
    Page<Employee> findAllByNameContaining(@Param("employee_name") String name, Pageable pageable);

    Employee findByEmployeeCode(String code);
}
