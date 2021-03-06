package medical_record.service.impl;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:25
*/

import medical_record.model.MedicalRecord;
import medical_record.repository.IMedicalRecordRepository;
import medical_record.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalRecordService implements IMedicalRecordService {
    @Autowired
    private IMedicalRecordRepository iMedicalRecordRepository;

    @Override
    public Iterable<MedicalRecord> findAll() {
        return iMedicalRecordRepository.findAll();
    }

    @Override
    public Optional<MedicalRecord> findById(Integer id) {
        return iMedicalRecordRepository.findById(id);
    }

    @Override
    public void save(MedicalRecord medicalRecord) {
        iMedicalRecordRepository.save(medicalRecord);
    }

    @Override
    public void remove(Integer id) {
        iMedicalRecordRepository.deleteById(id);
    }

    @Override
    public Page<MedicalRecord> findAllByMedicalRecordCodeContaining(String code, Pageable pageable) {
        return iMedicalRecordRepository.findAllByDeleteFlagAndMedicalRecordCodeContaining(false, code, pageable);
    }

    @Override
    public Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientCodeContaining(String code, Pageable pageable) {
        return iMedicalRecordRepository.findAllByDeleteFlagAndPatient_PatientCodeContaining(false, code, pageable);
    }

    @Override
    public Page<MedicalRecord> findAllByDeleteFlagAndPatient_PatientNameContaining(String name, Pageable pageable) {
        return iMedicalRecordRepository.findAllByDeleteFlagAndPatient_PatientNameContaining(false, name, pageable);
    }

    @Override
    public Page<MedicalRecord> findByAll(String medicalRecordCode, String patientCode, String patientName, String fromDate1, String toDate1, String fromDate2, String toDate2, Pageable pageable) {
        return iMedicalRecordRepository.findAllByDeleteFlagAndMedicalRecordCodeContainingAndPatient_PatientCodeContainingAndPatient_PatientNameContainingAndStartDateBetweenAndEndDateBetween(false, medicalRecordCode, patientCode, patientName, fromDate1, toDate1, fromDate2, toDate2, pageable);
    }

    @Override
    public void setDeleteFlagMutiple(List<String> idMutiple) {
        iMedicalRecordRepository.setDeleteFlagMutiple(idMutiple);
    }
}
