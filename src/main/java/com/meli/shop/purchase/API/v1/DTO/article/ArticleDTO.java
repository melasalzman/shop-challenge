package com.meli.shop.purchase.API.v1.DTO.article;

public class ArticleDTO {
    private Integer productId;
    private String name;
    private String category;
    private String brand;
    private Double price;
    private Integer stock;
    private Boolean freeShipping;
    private Double reputation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public Double getReputation() {
        return reputation;
    }

    public void setReputation(Double reputation) {
        this.reputation = reputation;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public ArticleDTO(Integer productId, String name, String category, String brand, Double price, Integer stock, Boolean freeShipping, Double reputation) {
        setProductId(productId);
        setName(name);
        setCategory(category);
        setBrand(brand);
        setPrice(price);
        setStock(stock);
        setFreeShipping(freeShipping);
        setReputation(reputation);
    }

    public ArticleDTO() {
    }
}
