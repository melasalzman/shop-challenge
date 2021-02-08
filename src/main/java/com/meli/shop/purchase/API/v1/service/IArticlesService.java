package com.meli.shop.purchase.API.v1.service;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticlesDTO;
import com.meli.shop.purchase.API.v1.exception.article.NoDataFoundException;

public interface IArticlesService {
    ArticlesDTO getArticles(ArticleFilterDTO articleFilterDTO) throws Exception, NoDataFoundException;
}
