package com.meli.shop.purchase.API.v1.repository.Impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseArticleDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseRequestDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.Model.Article;
import com.meli.shop.purchase.API.v1.Model.ArticleRequest;
import com.meli.shop.purchase.API.v1.Model.PurchaseRequest;
import com.meli.shop.purchase.API.v1.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import com.meli.shop.purchase.API.v1.utils.database.IDatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private IDatabase iDatabase;

    public ArrayList<ArticleDTO> getAllArticles() throws IOException {
        return getArticleDTOList(iDatabase.loadDatabase("src/main/resources/articles.json",Article.class));
    }

    private ArrayList<Article> loadArticlesDatabase() throws IOException {
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
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(purchaseRequestDTO);
        Files.write(new File("src/main/resources/purchase-requests.json").toPath(), Arrays.asList(json), StandardOpenOption.APPEND);
    }

    @Override
    public ArrayList<PurchaseRequestDTO> getAllPurchaseRequest() throws IOException {
        return getPurchaseRequestDTOList(iDatabase.loadDatabase("src/main/resources/purchase-requests.json",PurchaseRequest.class));
    }

    private ArrayList<PurchaseRequest> loadPurchaseRequestDatabase() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<PurchaseRequest> purchaseRequests = objectMapper.readValue(
                ResourceUtils.getFile("classpath:purchase-requests.json"),
                new TypeReference<>() {
                });
        return purchaseRequests;
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
