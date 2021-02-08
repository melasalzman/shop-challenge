package com.meli.shop.purchase.API.v1.model;

public class ArticleResponse {
    private Integer productId;
    private Integer discount;
    private Integer quantity;
    private Double totalPrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArticleResponse(Integer productId, Integer discount, Integer quantity, Double totalPrice) {
        this.productId = productId;
        this.discount = discount;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public ArticleResponse() {
    }
}
