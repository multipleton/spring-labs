package com.multipleton.spring.dto.book;

import com.multipleton.spring.model.Book;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class BookUpdateDto {
    private String tags;

    public BookUpdateDto(String tags) {
        this.tags = tags;
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
        book.setTags(tags);
    }
}
