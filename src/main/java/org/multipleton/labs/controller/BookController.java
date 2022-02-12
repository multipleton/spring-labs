package org.multipleton.labs.controller;

import org.multipleton.labs.dto.BookDto;
import org.multipleton.labs.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class BookController {
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/update-book")
    public String updateBookPage(Model model, @RequestParam Long bookId) {
        var book = bookService.findBookById(bookId);
        var bookDto = new BookDto();
        bookDto.setTags(book.getTags());
        bookDto.setId(book.getId());
        bookDto.setTitle(book.getTitle());
        bookDto.setAuthorId(book.getAuthor().getId());
        model.addAttribute("book", bookDto);
        return "update-book";
    }

    @PostMapping("/update-book")
    public String updateBook(@ModelAttribute(name = "book") BookDto book) {
        bookService.updateBook(book);
        return "redirect:books";
    }

    @PostMapping("/add-book")
    public String createBook(@ModelAttribute BookDto book) {
        bookService.createBook(book);
        return "redirect:books";
    }

    @PostMapping("/delete-book")
    public String deleteBook(@RequestParam Long bookId) {
        bookService.deleteBook(bookId);
        return "redirect:books";
    }

    @GetMapping("/books")
    public String allBooks(Model model) {
        var books = bookService.findAll();
        model.addAttribute("books", books);
        model.addAttribute("predicate", "All books");
        return "filtered-books";
    }

    @GetMapping("/books/author")
    public String booksByAuthor(Model model, @RequestParam String author) {
        var books = bookService.findBooksByAuthor(author);
        model.addAttribute("books", books);
        model.addAttribute("predicate", "Books by author: " + author);
        return "filtered-books";
    }

    @GetMapping("/books/title")
    public String booksByTitle(Model model, @RequestParam String title) {
        var books = bookService.findBookByTitle(title);
        model.addAttribute("books", books);
        model.addAttribute("predicate", "Books by title: " + title);
        return "filtered-books";
    }

    @GetMapping("/books/tags")
    public String booksByTags(Model model, @RequestParam(name = "tags") String rowTags) {
        var tags = Arrays.stream(rowTags.split(",")).toList();
        var books = bookService.findBooksByTags(tags);
        model.addAttribute("books", books);
        model.addAttribute("predicate", "Books by tags: " + tags);
        return "filtered-books";
    }
}
