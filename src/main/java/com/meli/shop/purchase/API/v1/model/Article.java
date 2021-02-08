package com.meli.shop.purchase.API.v1.model;

public class Article {
    private Integer productId;
    private String name;
    private String category;
    private String brand;
    private Double price;
    private Integer stock;
    private Boolean freeShipping;
    private Double reputation;
    private String shippingType;
    private Boolean featured;
    private Boolean arrivesTomorrow;
    private Boolean withoutInterest;
    private String condition;

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

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Boolean getArrivesTomorrow() {
        return arrivesTomorrow;
    }

    public void setArrivesTomorrow(Boolean arrivesTomorrow) {
        this.arrivesTomorrow = arrivesTomorrow;
    }

    public Boolean getWithoutInterest() {
        return withoutInterest;
    }

    public void setWithoutInterest(Boolean withoutInterest) {
        this.withoutInterest = withoutInterest;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Article(Integer productId, String name, String category, String brand, Double price,
                   Integer stock, Boolean freeShipping, Double reputation, String shippingType,
                   Boolean featured, Boolean arrivesTomorrow, Boolean withoutInterest, String condition) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.freeShipping = freeShipping;
        this.reputation = reputation;
        this.shippingType = shippingType;
        this.featured = featured;
        this.arrivesTomorrow = arrivesTomorrow;
        this.withoutInterest = withoutInterest;
        this.condition = condition;
    }

    public Article() {
    }
}
