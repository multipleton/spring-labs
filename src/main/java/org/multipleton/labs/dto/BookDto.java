package org.multipleton.labs.dto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BookDto {

    private Long id;

    private String title;

    private Long authorId;

    private String tags;

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

    public Set<String> getTags() {
        if (tags == null) {
            return new HashSet<>();
        }
        return Arrays.stream(tags.split(",")).collect(Collectors.toSet());
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = String.join(",", tags);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
