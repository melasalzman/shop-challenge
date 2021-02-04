package com.meli.shop.purchase.controller;

import com.meli.shop.purchase.DTO.Request.PurchaseRequestDTO;
import com.meli.shop.purchase.DTO.Request.ArticleFilterDTO;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;
import com.meli.shop.purchase.DTO.Response.PurchaseDTO;
import com.meli.shop.purchase.service.IArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class ArticlesController {
    /*Hacer como constructor*/
    @Autowired
    private IArticlesService iArticlesService;

    @GetMapping("/api/v1/articles")
    public ArrayList<ArticleDTO> getArticles(ArticleFilterDTO articleFilterDTO) throws Exception {
        return iArticlesService.getArticles(articleFilterDTO);
    }
}
