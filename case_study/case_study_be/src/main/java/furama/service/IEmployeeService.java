package furama.service;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 15:11
*/

import furama.model.employee_entity.Division;
import furama.model.employee_entity.EducationDegree;
import furama.model.employee_entity.Employee;
import furama.model.employee_entity.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IEmployeeService extends IGeneralService<Employee>{
    Page<Employee> findAllByName(String name, Pageable pageable);

    Iterable<Division> findAllDivision();

    Iterable<Position> findAllPosition();

    Iterable<EducationDegree> findAllEducationDegree();
}
