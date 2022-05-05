package thi_thuc_hanh.dto;
/*
    Created by Trinh Khai
    Date: 29/04/2022
    Time: 09:53
*/

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class PromotionalDTO implements Validator {
    private Integer promotionalId;
    @NotBlank(message = "Tiêu đề không được để trống.")
    private String title;
    @NotBlank(message = "Thời gian bắt đầu không được để trống.")
    private String startDate;
    @NotBlank(message = "Thời gian kết thúc không được để trống.")
    private String endDate;
    @NotNull(message = "Mức giảm giá không được để trống.")
    @Min(value = 10000, message = "Mức giảm giá phải lớn hơn 10.000 VND.")
    private Double discountRate;
    @NotBlank(message = "Chi tiết khuyến mãi không được để trống.")
    private String detail;
    private Boolean deleteFlag;

    public PromotionalDTO() {
        setDeleteFlag(false);
    }

    public Integer getPromotionalId() {
        return promotionalId;
    }

    public void setPromotionalId(Integer promotionalId) {
        this.promotionalId = promotionalId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        this.discountRate = discountRate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        PromotionalDTO promotionalDTO = (PromotionalDTO) target;
        String startDate = promotionalDTO.getStartDate();
        String endDate = promotionalDTO.getEndDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (!Objects.equals(startDate, "")) {
            LocalDate startDateLocalDate = LocalDate.parse(startDate, formatter);
            LocalDate now = LocalDate.now();
            if (startDateLocalDate.isBefore(now)) {
                errors.rejectValue("startDate", "", "Thời gian bắt đầu không hợp lệ");
            }
        }
        if (!Objects.equals(endDate, "") && !Objects.equals(startDate, "")) {
            LocalDate startDateLocalDate = LocalDate.parse(startDate, formatter);
            LocalDate endDateLocalDate = LocalDate.parse(endDate, formatter);

            if (endDateLocalDate.isBefore(startDateLocalDate.plusDays(1))) {
                errors.rejectValue("endDate", "", "Thời gian kết thúc phải lớn hơn thời gian hiện tại ít nhất 1 ngày.");
            }
        }
    }
}
