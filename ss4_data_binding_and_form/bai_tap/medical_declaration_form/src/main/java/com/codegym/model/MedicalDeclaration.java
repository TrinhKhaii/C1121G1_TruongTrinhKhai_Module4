package com.codegym.model;

import org.springframework.stereotype.Component;

/*
    Created by Trinh Khai
    Date: 31/03/2022
    Time: 16:03
*/
@Component
public class MedicalDeclaration {
    private Integer id;
    private String name;
    private String dateOFBirth;
    private String gender;
    private String nationality;
    private String idCard;
    private String vehicle;
    private String vehicleNumber;
    private Integer chairNumber;
    private String departureDay;
    private String endDay;
    private String cityUsedToPass;
    private String province;
    private String district;
    private String wards;
    private String address;
    private String phoneNumber;
    private String email;

    public MedicalDeclaration() {
    }

    public MedicalDeclaration(Integer id, String name, String dateOFBirth, String gender, String nationality, String idCard, String vehicle, String vehicleNumber, Integer chairNumber, String departureDay, String endDay, String cityUsedToPass, String province, String district, String wards, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.dateOFBirth = dateOFBirth;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.chairNumber = chairNumber;
        this.departureDay = departureDay;
        this.endDay = endDay;
        this.cityUsedToPass = cityUsedToPass;
        this.province = province;
        this.district = district;
        this.wards = wards;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOFBirth() {
        return dateOFBirth;
    }

    public void setDateOFBirth(String dateOFBirth) {
        this.dateOFBirth = dateOFBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public Integer getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(Integer chairNumber) {
        this.chairNumber = chairNumber;
    }

    public String getDepartureDay() {
        return departureDay;
    }

    public void setDepartureDay(String departureDay) {
        this.departureDay = departureDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getCityUsedToPass() {
        return cityUsedToPass;
    }

    public void setCityUsedToPass(String cityUsedToPass) {
        this.cityUsedToPass = cityUsedToPass;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWards() {
        return wards;
    }

    public void setWards(String wards) {
        this.wards = wards;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    @Override
    public String toString() {
        return "MedicalDeclaration{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOFBirth='" + dateOFBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", nationality='" + nationality + '\'' +
                ", idCard='" + idCard + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                ", chairNumber=" + chairNumber +
                ", departureDay='" + departureDay + '\'' +
                ", endDay='" + endDay + '\'' +
                ", cityUsedToPass='" + cityUsedToPass + '\'' +
                ", province='" + province + '\'' +
                ", district='" + district + '\'' +
                ", wards='" + wards + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
