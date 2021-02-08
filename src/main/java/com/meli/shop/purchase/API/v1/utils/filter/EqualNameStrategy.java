package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

import java.util.Locale;

public class EqualNameStrategy<T> implements FilterStrategy<T> {

    @Override
    public Boolean execute(T attribute, T value) {
       return String.valueOf(attribute).toLowerCase(Locale.ROOT).equals(String.valueOf(value).toLowerCase(Locale.ROOT));
    }
}
