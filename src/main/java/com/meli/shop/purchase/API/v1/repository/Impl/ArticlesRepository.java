package com.meli.shop.purchase.API.v1.repository.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.API.v1.Model.Article;
import com.meli.shop.purchase.API.v1.repository.IArticlesRepository;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class ArticlesRepository implements IArticlesRepository {
    @Override
    public ArrayList<ArticleDTO> getAllArticles() throws IOException {
        ArrayList<Article> articles = loadDatabase();
        return getArticleDTOList(articles);
    }

    private ArrayList<Article> loadDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<Article> articles = objectMapper.readValue(
                ResourceUtils.getFile("classpath:articles.json"),
                new TypeReference<>() {
                });
        return articles;
    }

    private ArrayList<ArticleDTO> getArticleDTOList(ArrayList<Article> articles) {
        ArrayList<ArticleDTO> articlesDTO = new ArrayList<>();
        for (Article article : articles) {
            ArticleDTO articleDTO = new ArticleDTO(
                    article.getProductId(),
                    article.getName(),
                    article.getCategory(),
                    article.getBrand(),
                    article.getPrice(),
                    article.getStock(),
                    article.getFreeShipping(),
                    article.getReputation());
            articlesDTO.add(articleDTO);
        }
        return articlesDTO;
    }
}
