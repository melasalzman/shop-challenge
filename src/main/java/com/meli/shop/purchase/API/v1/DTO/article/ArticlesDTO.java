package com.meli.shop.purchase.API.v1.DTO.article;

import java.util.ArrayList;

public class ArticlesDTO {
    private ArrayList<ArticleDTO> articles;

    public ArrayList<ArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleDTO> articles) {
        this.articles = articles;
    }

    public ArticlesDTO(ArrayList<ArticleDTO> articles) {
        this.articles = articles;
    }

    public ArticlesDTO() {
    }
}
