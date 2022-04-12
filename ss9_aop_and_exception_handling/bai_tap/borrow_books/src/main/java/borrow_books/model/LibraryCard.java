package borrow_books.model;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:13
*/
@Entity
public class LibraryCard {
    @Id
    private Integer libraryCardId;
    private Boolean borrowFlag;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private Book book;

    public LibraryCard() {
        this.borrowFlag = true;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
