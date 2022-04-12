package borrow_books.controller;

import borrow_books.dto.BookDto;
import borrow_books.model.Book;
import borrow_books.model.LibraryCard;
import borrow_books.service.IBookService;
import borrow_books.service.ILibraryCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/*
    Created by Trinh Khai
    Date: 11/04/2022
    Time: 14:27
*/
@Controller
@RequestMapping(value = "book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private ILibraryCardService iLibraryCardService;

    @GetMapping(value = "")
    public ModelAndView showBookList() {
        List<Book> books = iBookService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showCreateBookForm() {
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("bookDto", new BookDto());
        return modelAndView;
    }

    @PostMapping(value = "/save")
    public String addNewBook(@Valid @ModelAttribute("bookDto") BookDto bookDto,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/passbook/create";
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
        iBookService.save(book);
        return "redirect:/book";
    }

    @GetMapping(value = "/borrow/{id}")
    public ModelAndView showBorrowBookForm(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView("book/borrow");
        Book book = iBookService.findById(id);
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @PostMapping(value = "/borrow")
    public String borrowBook(@ModelAttribute("book") Book book) {
        if (book.getBookAmount() != 0) {
            LibraryCard libraryCard = new LibraryCard();
            libraryCard.setLibraryCardId((int) (Math.random() * 100000 + 1));
            libraryCard.setBook(book);
            iLibraryCardService.save(libraryCard);
            book.setBookAmount(book.getBookAmount() - 1);
            iBookService.save(book);
            return "redirect:/book";
        } else {
            System.out.println("Het sach");

            return "redirect:/book";
        }
    }

    @GetMapping(value = "/library_card_list")
    public ModelAndView showLibraryCardList() {
        List<LibraryCard> libraryCards = iLibraryCardService.findAll();
        ModelAndView modelAndView = new ModelAndView("book/library_card_list");
        modelAndView.addObject("libraryCards", libraryCards);
        return modelAndView;
    }

    @PostMapping(value = "/delete_library_card")
    public String returnBook(@RequestParam("idDelete") Integer idDelete) {
        LibraryCard libraryCard = iLibraryCardService.findById(idDelete);
        libraryCard.setBorrowFlag(false);
        iLibraryCardService.save(libraryCard);
        Book book = iBookService.findById(libraryCard.getBook().getBookId());
        book.setBookAmount(book.getBookAmount() + 1);
        iBookService.save(book);
        return "redirect:/book/library_card_list";
    }

    @ExceptionHandler(Exception.class)
    public String goError() {
        return "/book/error";
    }
}
