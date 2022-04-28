package product.dto;
/*
    Created by Trinh Khai
    Date: 27/04/2022
    Time: 21:27
*/

import product.model.Category;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductDTO {
    private Integer productId;

    @NotBlank(message = "Product name cannot empty.")
    private String productName;

    @NotNull(message = "Priduct price cannot empty.")
    @Min(value = 10000000, message = "Product price must greater than 10000000.")
    private Double productPrice;

    @NotNull(message = "Quantity cannot empty.")
    @Min(value = 0, message = "Quantity must be an integer.")
    private Integer quantity;

    @NotBlank(message = "Product color cannot empty.")
    private String productColor;

    private String description;

    private Category category;

    private Boolean deleteFlag;

    public ProductDTO() {
        setDeleteFlag(false);
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
