package medical_record.dto;
/*
    Created by Trinh Khai
    Date: 26/04/2022
    Time: 21:30
*/


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class PatientDTO {
    private Integer patientId;
    @NotBlank(message = "Mã bệnh nhân không được để trống.")
    private String patientCode;

    @NotBlank(message = "Tên bệnh nhân không được để trống.")
    @Pattern(regexp = "(^$|^[\\p{Lu}\\p{Ll}]+( [\\p{Lu}\\p{Ll}]+)*$)", message = "Tên bệnh nhân không hợp lệ.")
    private String patientName;

    public PatientDTO() {
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}
