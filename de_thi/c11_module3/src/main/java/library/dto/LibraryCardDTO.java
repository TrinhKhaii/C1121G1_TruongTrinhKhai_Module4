package library.dto;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:21
*/


import library.model.Student;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class LibraryCardDTO {
    private Integer libraryCardId;

    @NotBlank(message = "Mã thẻ mượn không được để trống.")
    @Pattern(regexp = "(^$|^S-\\d{4}$)", message = "Mã thẻ mượn phải có định dạng S-XXXX, trong đó X là số tự nhiên.")
    private String libraryCardCode;

    @Valid
    private BookDTO bookDTO;

    private Student student;

    private Boolean status;

    @NotBlank(message = "Ngày mượn không được để trống.")
    private String startDate;

    @NotBlank(message = "Ngày trả không được để trống.")
    private String endDate;

    public LibraryCardDTO() {
        setStatus(true);
    }

    public Integer getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(Integer libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public String getLibraryCardCode() {
        return libraryCardCode;
    }

    public void setLibraryCardCode(String libraryCardCode) {
        this.libraryCardCode = libraryCardCode;
    }

    public BookDTO getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(BookDTO bookDTO) {
        this.bookDTO = bookDTO;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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
}
