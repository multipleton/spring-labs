package com.multipleton.spring.dto.book;

import com.multipleton.spring.model.Book;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BookUpdateDto {
    private String title;
    private String tags;

    public BookUpdateDto(String title, String tags) {
        this.title = title;
        this.tags = tags;
    }

    public BookUpdateDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void updateBook(Book book) {
        Set<String> tags = Arrays.stream(this.tags.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
        book.setTitle(title);
        book.setTags(tags);
    }
}
