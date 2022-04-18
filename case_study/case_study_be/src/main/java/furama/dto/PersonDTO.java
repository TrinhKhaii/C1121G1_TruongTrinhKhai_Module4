package furama.dto;
/*
    Created by Trinh Khai
    Date: 17/04/2022
    Time: 14:08
*/


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public abstract class PersonDTO {
    @NotBlank(message = "Name can not empty.")
    private String name;

    @NotBlank(message = "Day of birth can not empty.")
    private String dayOfBirth;

    @NotBlank(message = "Id card can not empty.")
    @Pattern(regexp = "(^$|\\d{9}|\\d{12})", message = "Id card must be in XXXXXXXXX or XXXXXXXXXXXX format, where X is integer number.")
    private String idCard;

    @NotBlank(message = "Phone number can not empty.")
    @Pattern(regexp = "(^$|^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$)", message = "Wrong format of phone number.")
    private String phoneNumber;

    @NotBlank(message = "Email can not empty.")
    @Pattern(regexp = "(^$|^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,}){1,}$)", message = "Wrong format of email.")
    private String email;

    @NotBlank(message = "Address can not empty.")
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
