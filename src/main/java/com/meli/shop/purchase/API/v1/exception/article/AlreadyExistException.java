package com.meli.shop.purchase.API.v1.exception.article;

public class AlreadyExistException extends RuntimeException {

    public AlreadyExistException(String message) {
        super(String.format(message));
    }
}
