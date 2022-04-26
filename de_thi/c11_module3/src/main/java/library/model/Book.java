package library.model;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:26
*/
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;
    private String bookCode;
    private String bookName;
    private String author;
    private String description;
    private Integer quantity;

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

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Set<LibraryCard> getLibraryCards() {
        return libraryCards;
    }

    public void setLibraryCards(Set<LibraryCard> libraryCards) {
        this.libraryCards = libraryCards;
    }
}
