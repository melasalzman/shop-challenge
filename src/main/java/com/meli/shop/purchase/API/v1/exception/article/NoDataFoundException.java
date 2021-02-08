package com.meli.shop.purchase.API.v1.exception.article;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String message) {
        super(String.format(message));
    }
}
