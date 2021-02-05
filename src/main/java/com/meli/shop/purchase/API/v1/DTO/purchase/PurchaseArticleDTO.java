package com.meli.shop.purchase.API.v1.DTO.purchase;

public class PurchaseArticleDTO {
    private Integer productId;
    private Integer discount;
    private Integer quantity;

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

    public PurchaseArticleDTO(Integer productId, Integer discount, Integer quantity) {
        this.productId = productId;
        this.discount = discount;
        this.quantity = quantity;
    }

    public PurchaseArticleDTO() {
    }

    @Override
    public String toString() {
        return "PurchaseArticleDTO{" +
                "productId=" + productId +
                ", discount=" + discount +
                ", quantity=" + quantity +
                '}';
    }
}
