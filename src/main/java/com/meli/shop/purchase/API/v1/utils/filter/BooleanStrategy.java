package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

public class BooleanStrategy<T> implements FilterStrategy<T> {
    @Override
    public Boolean execute(T attribute, T value) {
        return Boolean.parseBoolean((String) value) == (Boolean) attribute;
    }
}
