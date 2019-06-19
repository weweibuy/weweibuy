package com.weweibuy.webuy.learning.spring.model.po;

public class TestDog {
    private Long id;

    private Long userId;

    private String dog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog == null ? null : dog.trim();
    }
}