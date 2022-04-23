package com.multipleton.spring.controller.rest;

import com.multipleton.spring.dto.author.AuthorCreateDto;
import com.multipleton.spring.dto.author.AuthorDto;
import com.multipleton.spring.dto.author.AuthorUpdateDto;
import com.multipleton.spring.dto.book.BookDto;
import com.multipleton.spring.service.AuthorService;
import com.multipleton.spring.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Authors")
@RestController
@RequestMapping("/rest")
public class AuthorRestController extends FrontRestController {

    private final AuthorService authorService;
    private final BookService bookService;

    public AuthorRestController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @ApiOperation("Get all authors")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    @GetMapping("/authors")
    public List<AuthorDto> getAllAuthors() {
        return authorService.findAllAuthors();
    }

    @ApiOperation("Get author")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @GetMapping("/authors/{authorId}")
    public AuthorDto getAuthor(@PathVariable Long authorId) {
        return authorService.getAuthor(authorId);
    }

    @ApiOperation("Create author")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST")
    })
    @PostMapping("/authors")
    public AuthorDto createAuthor(@RequestBody AuthorCreateDto dto) {
        return authorService.createAuthor(dto);
    }

    @ApiOperation("Update author")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "BAD_REQUEST"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @PutMapping("/authors/{authorId}")
    public AuthorDto updateAuthor(@PathVariable Long authorId,
                                  @RequestBody AuthorUpdateDto dto) {
        return authorService.updateAuthor(authorId, dto);
    }

    @ApiOperation("Delete author")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "NOT_FOUND")
    })
    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
    }

    @ApiOperation("Get author books")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })
    @GetMapping("/authors/{authorId}/books")
    public List<BookDto> getAuthorBooks(@PathVariable Long authorId) {
        return bookService.findBooksByAuthorId(authorId);
    }

}
