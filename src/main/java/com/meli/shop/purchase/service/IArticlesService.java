package com.meli.shop.purchase.service;

import com.meli.shop.purchase.DTO.Request.ArticleFilterDTO;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IArticlesService {
    ArrayList<ArticleDTO> getArticles(ArticleFilterDTO articleFilterDTO) throws Exception;
}
