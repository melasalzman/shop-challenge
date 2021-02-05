package com.meli.shop.purchase.API.v1.repository;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IArticlesRepository {
    ArrayList<ArticleDTO> getAllArticles() throws IOException;
}
