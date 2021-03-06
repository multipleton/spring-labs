package com.multipleton.spring.dto.book;

import com.multipleton.spring.dto.author.AuthorDto;
import com.multipleton.spring.model.Book;

import java.util.Set;

public class BookDto {
    private Long id;
    private String title;
    private AuthorDto author;
    private Set<String> tags;
    private BookStatus status;

    public BookDto(Long id, String title, AuthorDto author, Set<String> tags, BookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.tags = tags;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public static BookDto from(Book book) {
        return new BookDto(book.getId(), book.getTitle(), AuthorDto.from(book.getAuthor()), book.getTags(), book.getStatus());
    }
}
