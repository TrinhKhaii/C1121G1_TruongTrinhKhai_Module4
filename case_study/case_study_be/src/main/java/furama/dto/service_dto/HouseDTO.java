package furama.dto.service_dto;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 20:39
*/

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class HouseDTO extends ServiceDTO{
    @NotBlank(message = "Tiêu chuẩn phòng không được để trống.")
    private String standardRoom;

    @NotBlank(message = "Mô tả tiện nghi khác không được để trống.")
    private String descritionOtherConvenience;

    @Min(value = 0, message = "Số tầng phải là số dương.")
    private Integer numberOdFloors;

    public HouseDTO() {
        setDeleteFlag(false);
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescritionOtherConvenience() {
        return descritionOtherConvenience;
    }

    public void setDescritionOtherConvenience(String descritionOtherConvenience) {
        this.descritionOtherConvenience = descritionOtherConvenience;
    }

    public Integer getNumberOdFloors() {
        return numberOdFloors;
    }

    public void setNumberOdFloors(Integer numberOdFloors) {
        this.numberOdFloors = numberOdFloors;
    }
}
