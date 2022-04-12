package borrow_books.model;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 12:39
*/
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private Integer bookAmount;

    @OneToMany(mappedBy = "book")
    private Set<LibraryCard> libraryCards;

    public Book() {
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

    public Set<LibraryCard> getLibraryCards() {
        return libraryCards;
    }

    public void setLibraryCards(Set<LibraryCard> libraryCards) {
        this.libraryCards = libraryCards;
    }
}
