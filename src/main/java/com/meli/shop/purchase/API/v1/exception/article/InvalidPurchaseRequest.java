package com.meli.shop.purchase.API.v1.exception.article;

public class InvalidPurchaseRequest extends RuntimeException {

    public InvalidPurchaseRequest(String message) {
        super(String.format(message));
    }
}
