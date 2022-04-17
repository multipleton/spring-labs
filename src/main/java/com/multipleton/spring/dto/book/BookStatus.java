package com.multipleton.spring.dto.book;

public enum BookStatus {
    IN_STOCK("In stock"),
    OUT_OF_STOCK("Out of stock"),
    ONLINE("Online");

    private String title;

    BookStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
