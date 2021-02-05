package com.meli.shop.purchase.API.v1.service;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticlesDTO;

import java.util.ArrayList;

public interface IArticlesService {
    ArticlesDTO getArticles(ArticleFilterDTO articleFilterDTO) throws Exception;
}
