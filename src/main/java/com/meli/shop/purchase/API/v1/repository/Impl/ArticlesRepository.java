package com.meli.shop.purchase.API.v1.repository.Impl;

import com.meli.shop.purchase.API.v1.model.Article;
import com.meli.shop.purchase.API.v1.repository.IArticlesRepository;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.utils.database.IDatabase;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;

@Repository
public class ArticlesRepository implements IArticlesRepository {
    private final IDatabase iDatabase;
    private final String articlesPath = "src/main/resources/articles.json";

    public ArticlesRepository(IDatabase iDatabase) {
        this.iDatabase = iDatabase;
    }

    @Override
    public ArrayList<ArticleDTO> getAllArticles() throws IOException {
        return getArticleDTOList(iDatabase.loadDatabase(articlesPath, Article.class));
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
                    article.getReputation(),
                    article.getShippingType(),
                    article.getFeatured(),
                    article.getArrivesTomorrow(),
                    article.getWithoutInterest(),
                    article.getCondition());
            articlesDTO.add(articleDTO);
        }
        return articlesDTO;
    }
}
