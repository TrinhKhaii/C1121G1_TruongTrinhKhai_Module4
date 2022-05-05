package thi_thuc_hanh.model;

import javax.persistence.*;

/*
    Created by Trinh Khai
    Date: 29/04/2022
    Time: 09:13
*/
@Entity
public class Promotional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer promotionalId;
    private String title;
    private String startDate;
    private String endDate;
    private Double discountRate;
    @Column(columnDefinition = "text")
    private String detail;
    private Boolean deleteFlag;

    public Promotional() {
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
}
