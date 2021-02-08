package com.meli.shop.purchase.API.v1.controller;

import com.meli.shop.purchase.API.v1.DTO.article.ArticleFilterDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticlesDTO;
import com.meli.shop.purchase.API.v1.service.IArticlesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ArticleController {
    private final IArticlesService iArticlesService;

    public ArticleController(IArticlesService iArticlesService) {
        this.iArticlesService = iArticlesService;
    }

    @GetMapping("/articles")
    public ArticlesDTO getArticles(ArticleFilterDTO articleFilterDTO) throws Exception {
        return iArticlesService.getArticles(articleFilterDTO);
    }
}
