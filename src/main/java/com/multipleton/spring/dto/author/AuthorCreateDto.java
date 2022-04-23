package com.multipleton.spring.dto.author;

import com.multipleton.spring.model.Author;

public class AuthorCreateDto {
    private String name;

    public AuthorCreateDto(String name) {
        this.name = name;
    }

    public AuthorCreateDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author toAuthor() {
        return new Author(null, name);
    }
}
