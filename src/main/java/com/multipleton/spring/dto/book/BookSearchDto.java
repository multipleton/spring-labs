package com.multipleton.spring.dto.book;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BookSearchDto {
    private String title;
    private String author;
    private String tags;

    public BookSearchDto(String title, String author, String tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTags() {
        return tags;
    }

    public Set<String> getTagsSet() {
        if (tags == null || tags.isEmpty()) {
            return new HashSet<>();
        }
        return Arrays.stream(tags.split(","))
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isEmpty() {
        return (title == null || title.isEmpty())
                && (author == null || author.isEmpty())
                && (tags == null || tags.isEmpty());
    }
}
