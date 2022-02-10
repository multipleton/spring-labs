package org.multipleton.labs.model;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import static java.util.Optional.ofNullable;

public class Book {

    private final Set<String> tags;
    private Long id;
    private String title;
    private Author author;

    public Book(Long id, String title, Set<String> tags, Author author) {
        this.id = id;
        this.title = title;
        this.tags = ofNullable(tags).orElse(new HashSet<>());
        this.author = author;
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

    public boolean isAuthor(Long id) {
        return author.getId().equals(id);
    }

    public boolean hasAnyTag(List<String> tags) {
        for (String tag : tags) {
            if (tags.contains(tag)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                '}';
    }
}
