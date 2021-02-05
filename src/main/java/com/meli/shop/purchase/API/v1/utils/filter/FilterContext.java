package com.meli.shop.purchase.API.v1.utils.filter;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FilterContext {
    private FilterStrategy filterStrategy;

    public void setStrategy(FilterStrategy filterStrategy) {
        this.filterStrategy = filterStrategy;
    }

    public ArrayList<ArticleDTO> filterArticles(ArrayList<ArticleDTO> articles, String filterType) {
        return (ArrayList<ArticleDTO>) articles.stream().filter(article ->
                filterStrategy.execute(article,filterType))
                .collect(Collectors.toList());
    }
}
