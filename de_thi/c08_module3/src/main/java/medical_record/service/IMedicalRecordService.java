package medical_record.service;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:24
*/

import medical_record.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMedicalRecordService extends IGeneralService<MedicalRecord>{
    Page<MedicalRecord> findAllByMedicalRecordCodeContaining(String code, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientCodeContaining(String code, Pageable pageable);

    Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientNameContaining(String name, Pageable pageable);
}
