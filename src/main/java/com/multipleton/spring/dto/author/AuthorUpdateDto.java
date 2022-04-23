package com.multipleton.spring.dto.author;

import com.multipleton.spring.model.Author;

public class AuthorUpdateDto {
    private String name;

    public AuthorUpdateDto(String name) {
        this.name = name;
    }

    public AuthorUpdateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateAuthor(Author author) {
        author.setName(name);
    }
}
