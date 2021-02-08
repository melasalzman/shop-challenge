package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

public class FilterContext<T> {
    private FilterStrategy filterStrategy;

    public void setStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public Boolean filter(T attribute, T value) {
        return filterStrategy.execute(attribute, value);
    }
}
