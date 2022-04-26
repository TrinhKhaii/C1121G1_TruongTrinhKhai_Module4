package library.service.impl;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:28
*/

import library.model.Student;
import library.repositpry.IStudentRepository;
import library.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public Iterable<Student> findAll() {
        return iStudentRepository.findAll();
    }
}
