package borrow_books.repository;
/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:25
*/

import borrow_books.model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryRepository extends JpaRepository<LibraryCard, Integer> {
}
