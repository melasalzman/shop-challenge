package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

public class HighReputationStrategy implements FilterStrategy{
    @Override
    public Boolean execute(ArticleDTO articleDTO, String filterType) {
        return articleDTO.getReputation()>3;
    }
}
