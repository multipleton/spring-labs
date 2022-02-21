package com.multipleton.spring.model;

import com.multipleton.spring.dto.book.BookStatus;

import java.util.Objects;
import java.util.Set;

public class Book {
    private Long id;
    private String title;
    private Author author;
    private Set<String> tags;
    private BookStatus status;

    public Book(Long id, String title, Author author, Set<String> tags, BookStatus status) {
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id) && title.equals(book.title) && author.equals(book.author) && tags.equals(book.tags) && status == book.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, tags, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                ", status=" + status +
                '}';
    }
}
