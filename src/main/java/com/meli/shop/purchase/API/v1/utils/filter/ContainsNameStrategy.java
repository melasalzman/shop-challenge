package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

import java.util.Locale;

public class ContainsNameStrategy<T> implements FilterStrategy<T> {

    @Override
    public Boolean execute(T attribute, T value) {
       return String.valueOf(attribute).toLowerCase(Locale.ROOT).contains(String.valueOf(value));
    }
}
