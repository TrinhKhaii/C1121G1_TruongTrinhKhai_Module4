package borrow_books.dto;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:19
*/


public class LibraryCardDto {
    private Integer libraryCardId;
    private boolean borrowFlag;

    private BookDto bookDto;
    public LibraryCardDto() {
    }

    public Integer getLibraryCardId() {
        return libraryCardId;
    }

    public void setLibraryCardId(Integer libraryCardId) {
        this.libraryCardId = libraryCardId;
    }

    public boolean isBorrowFlag() {
        return borrowFlag;
    }

    public void setBorrowFlag(boolean borrowFlag) {
        this.borrowFlag = borrowFlag;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
