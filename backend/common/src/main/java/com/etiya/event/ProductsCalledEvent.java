package com.etiya.event;

public class ProductsCalledEvent {
    public ProductsCalledEvent() {
    }

    public ProductsCalledEvent(Long id) {
        this.id = id;
    }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
