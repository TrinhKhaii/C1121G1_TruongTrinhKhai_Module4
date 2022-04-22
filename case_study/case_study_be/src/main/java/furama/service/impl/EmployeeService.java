package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 15:15
*/

import furama.model.employee_entity.Division;
import furama.model.employee_entity.EducationDegree;
import furama.model.employee_entity.Employee;
import furama.model.employee_entity.Position;
import furama.repository.employee_repository.IDivisionRepository;
import furama.repository.employee_repository.IEducationDegreeRepository;
import furama.repository.employee_repository.IEmployeeRepository;
import furama.repository.employee_repository.IPositionRepository;
import furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Autowired
    private IPositionRepository iPositionRepository;

    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public Iterable<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee customer) {
        iEmployeeRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        iEmployeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByName(String name, Pageable pageable) {
        return iEmployeeRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Iterable<Division> findAllDivision() {
        return iDivisionRepository.findAll();
    }

    @Override
    public Iterable<Position> findAllPosition() {
        return iPositionRepository.findAll();
    }

    @Override
    public Iterable<EducationDegree> findAllEducationDegree() {
        return iEducationDegreeRepository.findAll();
    }
}
