package com.multipleton.spring.dto.book;

import com.multipleton.spring.model.Author;
import com.multipleton.spring.model.Book;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BookCreateDto {
    private String title;
    private Long authorId;
    private String tags;

    public BookCreateDto(String title, Long authorId, String tags) {
        this.title = title;
        this.authorId = authorId;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Book toBook(Author author) {
        return new Book(null, title, author, Arrays.stream(tags.split(",")).collect(Collectors.toSet()));
    }
}
