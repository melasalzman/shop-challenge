package com.meli.shop.purchase.API.v1.exception.article;

public class InvalidArgumentException extends RuntimeException {

    public InvalidArgumentException(String message) {
        super(String.format(message));
    }
}
