package furama.service.impl;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 15:15
*/

import furama.model.employee_entity.Employee;
import furama.repository.employee_repository.IEmployeeRepository;
import furama.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

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
}
