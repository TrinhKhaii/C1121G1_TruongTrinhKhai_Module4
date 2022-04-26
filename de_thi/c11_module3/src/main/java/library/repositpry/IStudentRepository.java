package library.repositpry;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:27
*/

import library.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
}
