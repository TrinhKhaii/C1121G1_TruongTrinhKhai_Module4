package borrow_books.dto;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:18
*/

public class BookDto {
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private Integer bookAmount;

    public BookDto() {
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public Integer getBookAmount() {
        return bookAmount;
    }

    public void setBookAmount(Integer bookAmount) {
        this.bookAmount = bookAmount;
    }
}
