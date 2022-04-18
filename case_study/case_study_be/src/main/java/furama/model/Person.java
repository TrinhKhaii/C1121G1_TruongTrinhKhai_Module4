package furama.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/*
    Created by Trinh Khai
    Date: 16/04/2022
    Time: 23:55
*/
@MappedSuperclass
public abstract class Person {
    @NotNull
    private String name;
    @NotNull
    private String dayOfBirth;
    @NotNull
    private String idCard;
    @NotNull
    private String phoneNumber;
    private String email;
    private String address;

    private Boolean deleteFlag;

    public Person() {
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
