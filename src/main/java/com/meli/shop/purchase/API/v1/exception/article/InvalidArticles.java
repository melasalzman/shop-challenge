package com.meli.shop.purchase.API.v1.exception.article;

public class InvalidArticles extends RuntimeException {

    public InvalidArticles(String message) {
        super(String.format(message));
    }
}
