package medical_record.repository;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:38
*/

import medical_record.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPatientRepository extends JpaRepository<Patient, Integer> {
}
