package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

public interface FilterStrategy {
    Boolean execute(ArticleDTO article, String filterType);
}
