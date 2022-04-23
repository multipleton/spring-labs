package com.multipleton.spring.controller;

import com.multipleton.spring.dto.book.BookCreateDto;
import com.multipleton.spring.dto.book.BookSearchDto;
import com.multipleton.spring.dto.book.BookUpdateDto;
import com.multipleton.spring.service.AuthorService;
import com.multipleton.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;
    private AuthorService authorService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setAuthorService(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String books(BookSearchDto bookSearchDto, Model model) {
        model.addAttribute("bookSearchDto", bookSearchDto);
        model.addAttribute("books", bookService.searchBooks(bookSearchDto, Pageable.unpaged()));
        return "books";
    }

    @GetMapping("/admin")
    public String books(Model model) {
        model.addAttribute("books", bookService.findAllBooks());
        return "admin";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("authors", authorService.findAllAuthors());
        model.addAttribute("bookCreateDto", new BookCreateDto());
        return "create-book";
    }

    @PostMapping("/create")
    public String create(BookCreateDto bookCreateDto) {
        bookService.createBook(bookCreateDto);
        return "redirect:/books/admin";
    }

    @GetMapping("/update/{bookId}")
    public String update(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        model.addAttribute("bookUpdateDto", new BookUpdateDto());
        return "update-book";
    }

    @PostMapping("/update/{bookId}")
    public String update(@PathVariable Long bookId, BookUpdateDto bookUpdateDto) {
        bookService.updateBook(bookId, bookUpdateDto);
        return "redirect:/books/admin";
    }

    @GetMapping("/delete/{bookId}")
    public String delete(@PathVariable Long bookId, Model model) {
        model.addAttribute("book", bookService.getBook(bookId));
        return "delete-book";
    }

    @PostMapping("/delete/{bookId}")
    public String delete(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:/books/admin";
    }

}
