package com.meli.shop.purchase.repository;

import com.meli.shop.purchase.DTO.Response.ArticleDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IArticlesRepository {
    ArrayList<ArticleDTO> getAllArticles() throws IOException;
}
