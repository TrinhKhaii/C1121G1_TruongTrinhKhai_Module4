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
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    Page<MedicalRecord> findAllByDeleteFlagAndMedicalRecordCodeContaining(Boolean flag, String code, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientCodeContaining(Boolean flag, String code, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientNameContaining(Boolean flag, String name, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndMedicalRecordCodeContainingAndPatient_PatientCodeContainingAndPatient_PatientNameContainingAndStartDateBetweenAndEndDateBetween(Boolean flag, String medicalRecordCode, String patientCode, String patientName, String fromDate1, String toDate1, String fromDate2, String toDate2, Pageable pageable);

    @Modifying
    @Query(value = "update medical_record " +
            "set delete_flag = 1 where medical_record_id in :idMutiple ", nativeQuery = true)
    void setDeleteFlagMutiple(@Param("idMutiple") List<String> idMutiple);
}
