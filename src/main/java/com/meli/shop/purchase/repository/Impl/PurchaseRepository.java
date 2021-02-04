package com.meli.shop.purchase.repository.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.DTO.Request.PurchaseArticleDTO;
import com.meli.shop.purchase.DTO.Request.PurchaseRequestDTO;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;
import com.meli.shop.purchase.Model.Article;
import com.meli.shop.purchase.Model.ArticleRequest;
import com.meli.shop.purchase.Model.PurchaseRequest;
import com.meli.shop.purchase.repository.IPurchaseRepository;
import com.meli.shop.purchase.utils.sorter.database.IDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    IDatabase iDatabase;

    public ArrayList<ArticleDTO> getAllArticles() throws IOException {
        ArrayList<Article> articles = iDatabase.loadDatabase("classpath:articles.json");
        return getArticleDTOList(articles);
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

    @Override
    public ArticleDTO getArticleById(Integer productId) throws IOException {
        return getAllArticles().stream()
                .filter(article -> article.getProductId() == productId)
                .findAny()
                .orElse(null);
    }

    @Override
    public void savePurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("classpath:purchase-request"), purchaseRequestDTO);
    }

    @Override
    public ArrayList<PurchaseRequestDTO> getAllPurchaseRequest() throws IOException {
        return getPurchaseRequestDTOList(iDatabase.loadDatabase("classpath:purchase-request"));
    }

    private ArrayList<PurchaseRequestDTO> getPurchaseRequestDTOList(ArrayList<PurchaseRequest> purchaseRequests) {
        ArrayList<PurchaseRequestDTO> purchaseRequestsDTO = new ArrayList<>();
        for (PurchaseRequest purchaseRequest : purchaseRequests) {
            PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO(
                    purchaseRequest.getUserName(),
                    getPurchaseArticleDTOList(purchaseRequest.getArticles())
            );
            purchaseRequestsDTO.add(purchaseRequestDTO);
        }
        return purchaseRequestsDTO;
    }

    private ArrayList<PurchaseArticleDTO> getPurchaseArticleDTOList(ArrayList<ArticleRequest> purchaseArticle) {
        ArrayList<PurchaseArticleDTO> purchaseArticlesDTO = new ArrayList<>();
        for (ArticleRequest article : purchaseArticle) {
            PurchaseArticleDTO purchaseArticleDTO = new PurchaseArticleDTO(
                    article.getProductId(), article.getDiscount(), article.getQuantity()
            );
            purchaseArticlesDTO.add(purchaseArticleDTO);
        }
        return purchaseArticlesDTO;
    }


}
