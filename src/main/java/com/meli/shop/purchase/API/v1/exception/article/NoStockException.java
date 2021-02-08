package com.meli.shop.purchase.API.v1.exception.article;

public class NoStockException extends RuntimeException {

    public NoStockException(String message) {
        super(String.format(message));
    }
}
