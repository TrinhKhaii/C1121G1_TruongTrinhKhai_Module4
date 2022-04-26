package library.repositpry;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 21:39
*/

import library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByBookNameContaining(String bookName, Pageable pageable);
}
