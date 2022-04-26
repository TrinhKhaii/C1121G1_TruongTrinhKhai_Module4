package medical_record.dto;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:29
*/


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class MedicalRecordDTO implements Validator {
    private Integer medicalRecordId;
    @NotBlank(message = "Mã bệnh án không được để trống.")
    private String medicalRecordCode;

    @Valid
    private PatientDTO patientDTO;
    @NotBlank(message = "Ngày nhập viện không được để trống.")
    private String startDate;
    @NotBlank(message = "Ngày xuất viện không được để trống.")
    private String endDate;
    @NotBlank(message = "Lý do nhập viện không được để trống.")
    private String reason;
    private Boolean deleteFlag;

    public MedicalRecordDTO() {
        setDeleteFlag(false);
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public String getMedicalRecordCode() {
        return medicalRecordCode;
    }

    public void setMedicalRecordCode(String medicalRecordCode) {
        this.medicalRecordCode = medicalRecordCode;
    }

    public PatientDTO getPatientDTO() {
        return patientDTO;
    }

    public void setPatientDTO(PatientDTO patientDTO) {
        this.patientDTO = patientDTO;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        MedicalRecordDTO medicalRecordDTO = (MedicalRecordDTO) target;
        String startDate = medicalRecordDTO.getStartDate();
        String endDate = medicalRecordDTO.getEndDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (!Objects.equals(startDate, "")) {
            LocalDate startDateLocalDate = LocalDate.parse(startDate, formatter);
            LocalDate endDateLocalDate = LocalDate.parse(endDate, formatter);
            if (endDateLocalDate.isBefore(startDateLocalDate)) {
                errors.rejectValue("endDate", "", "Ngày ra viện không hợp lệ");
            }

        }
    }
}
