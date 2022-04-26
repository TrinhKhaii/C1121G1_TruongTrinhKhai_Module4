package medical_record.repository;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:24
*/

import medical_record.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    Page<MedicalRecord> findAllByDeleteFlagAndMedicalRecordCodeContaining(Boolean flag, String code, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientCodeContaining(Boolean flag, String code, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientNameContaining(Boolean flag, String name, Pageable pageable);
}
