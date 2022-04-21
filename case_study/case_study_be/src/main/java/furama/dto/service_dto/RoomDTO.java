package furama.dto.service_dto;
/*
    Created by Trinh Khai
    Date: 21/04/2022
    Time: 20:39
*/

import javax.validation.constraints.NotBlank;

public class RoomDTO extends ServiceDTO{
    @NotBlank(message = "Dịch vụ miễn phí đi kèm không được để trống.")
    private String freeServiceInclude;

    public RoomDTO() {
        setDeleteFlag(false);
    }

    public String getFreeServiceInclude() {
        return freeServiceInclude;
    }

    public void setFreeServiceInclude(String freeServiceInclude) {
        this.freeServiceInclude = freeServiceInclude;
    }
}
