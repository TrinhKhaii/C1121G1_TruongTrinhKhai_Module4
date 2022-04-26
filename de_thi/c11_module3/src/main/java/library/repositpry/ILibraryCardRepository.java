package library.repositpry;
/*
    Created by Trinh Khai
    Date: 25/04/2022
    Time: 22:05
*/

import library.model.LibraryCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILibraryCardRepository extends JpaRepository<LibraryCard, Integer> {
    Page<LibraryCard> findAllByStatusAndLibraryCardCodeContaining(Boolean status, String libraryCardCode, Pageable pageable);
}
