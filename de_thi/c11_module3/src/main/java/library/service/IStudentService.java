package library.service;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:27
*/

import library.model.Student;

public interface IStudentService {
    Iterable<Student> findAll();
}
