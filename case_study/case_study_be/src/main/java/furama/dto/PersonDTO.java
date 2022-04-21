package furama.dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 14:08
*/


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public abstract class PersonDTO {
    @NotBlank(message = "Tên không được để trống.")
    private String name;

    @NotBlank(message = "Ngày sinh không được để trống.")
    private String dayOfBirth;

    @NotBlank(message = "CMND không được để trống.")
    @Pattern(regexp = "(^$|\\d{9}|\\d{12})", message = "CMND phải có định dạng XXXXXXXXX hoặc XXXXXXXXXXXXXXXX, trong đó X là số tự nhiên.")
    private String idCard;

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "(^$|^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$)", message = "Sai định dạng số điện thoại")
    private String phoneNumber;

    @Pattern(regexp = "(^$|^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$)", message = "Sai định dạng email")
    private String email;

    private String address;

    private Boolean deleteFlag;

    public PersonDTO() {
        setDeleteFlag(false);
    }

    public PersonDTO(String name, String dayOfBirth, String idCard, String phoneNumber, String email, String address, Boolean deleteFlag) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.deleteFlag = deleteFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
