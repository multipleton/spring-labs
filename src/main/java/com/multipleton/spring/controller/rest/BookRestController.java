package com.multipleton.spring.controller.rest;

import com.multipleton.spring.dto.book.BookCreateDto;
import com.multipleton.spring.dto.book.BookDto;
import com.multipleton.spring.dto.book.BookSearchDto;
import com.multipleton.spring.dto.book.BookUpdateDto;
import com.multipleton.spring.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class BookRestController extends FrontRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("/books")
    public BookDto createBook(@RequestBody BookCreateDto dto) {
        return bookService.createBook(dto);
    }

    @PutMapping("/books/{bookId}")
    public BookDto updateBook(@PathVariable Long bookId,
                              @RequestBody BookUpdateDto dto) {
        return bookService.updateBook(bookId, dto);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("/books/search")
    public List<BookDto> searchBooks(BookSearchDto dto) {
        return bookService.searchBooks(dto);
    }

}
