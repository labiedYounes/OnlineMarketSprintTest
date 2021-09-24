package com.example.DTOs;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private Long categoryId;
    private String imgs;
    private int quantity;
    private float price;

    public ProductDTO(Long id, String name, String description, Long userId, Long categoryId, String imgs, int quantity, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.categoryId = categoryId;
        this.imgs = imgs;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
