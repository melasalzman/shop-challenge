package com.meli.shop.purchase.DTO.Response;

public class PurchaseDTO {
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PurchaseDTO(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public PurchaseDTO() {
    }
}
