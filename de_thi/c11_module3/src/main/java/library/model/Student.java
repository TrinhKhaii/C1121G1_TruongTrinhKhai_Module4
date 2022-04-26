package library.model;

import javax.persistence.*;
import java.util.Set;

/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:28
*/
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private String className;

    @OneToMany(mappedBy = "student")
    private Set<LibraryCard> libraryCards;

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Set<LibraryCard> getLibraryCards() {
        return libraryCards;
    }

    public void setLibraryCards(Set<LibraryCard> libraryCards) {
        this.libraryCards = libraryCards;
    }
}
