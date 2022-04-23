package com.multipleton.spring.controller.rest;

import com.multipleton.spring.dto.book.BookCreateDto;
import com.multipleton.spring.dto.book.BookDto;
import com.multipleton.spring.dto.book.BookSearchDto;
import com.multipleton.spring.dto.book.BookUpdateDto;
import com.multipleton.spring.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Books")
@RestController
@RequestMapping("/rest")
public class BookRestController extends FrontRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @ApiOperation("Get book")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @GetMapping("/books/{bookId}")
    public BookDto getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @ApiOperation("Create book")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")
    })
    @PostMapping("/books")
    public BookDto createBook(@RequestBody BookCreateDto dto) {
        return bookService.createBook(dto);
    }

    @ApiOperation("Update book")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @PutMapping("/books/{bookId}")
    public BookDto updateBook(@PathVariable Long bookId,
                              @RequestBody BookUpdateDto dto) {
        return bookService.updateBook(bookId, dto);
    }

    @ApiOperation("Delete book")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
    }

    @ApiOperation("Search books")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    @GetMapping("/books/search")
    public Page<BookDto> searchBooks(BookSearchDto dto,
                                     @RequestParam(defaultValue = "0") Integer page,
                                     @RequestParam(defaultValue = "20") Integer size) {
        return bookService.searchBooks(dto, PageRequest.of(page, size));
    }

}
