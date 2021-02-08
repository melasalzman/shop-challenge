package com.meli.shop.purchase.API.v1.repository.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.shop.purchase.API.v1.DTO.purchase.*;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.model.*;
import com.meli.shop.purchase.API.v1.repository.IPurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.meli.shop.purchase.API.v1.utils.database.IDatabase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class PurchaseRepository implements IPurchaseRepository {

    @Autowired
    private IDatabase iDatabase;

    public ArrayList<ArticleDTO> getAllArticles() throws IOException {
        return getArticleDTOList(iDatabase.loadDatabase("src/main/resources/articles.json", Article.class));
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
        ArrayList<PurchaseRequestDTO> purchases = new ArrayList<>();
        for (PurchaseRequestDTO purchase : getAllPurchaseRequest()) {
            purchases.add(purchase);
        }
        purchases.add(purchaseRequestDTO);
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(purchases);
        Files.write(new File("src/main/resources/purchase-requests.json").toPath(), Arrays.asList(json));
    }

    @Override
    public ArrayList<PurchaseRequestDTO> getAllPurchaseRequest() throws IOException {
        ArrayList<PurchaseRequestDTO> purchasesRequest = getPurchaseRequestDTOList(iDatabase.loadDatabase("src/main/resources/purchase-requests.json", PurchaseRequest.class));
        return purchasesRequest;
    }

    @Override
    public ArrayList<PurchaseRequestDTO> getPurchaseRequestsByUserName(String username) throws IOException {
        return (ArrayList<PurchaseRequestDTO>) getAllPurchaseRequest().stream().filter(purchase ->
                purchase.getUserName().equals(username))
                .collect(Collectors.toList());
    }

    @Override
    public Integer getLastId() throws IOException {
        return getAllPurchaseRequest().size() + 1;
    }

    private ArrayList<PurchaseRequestDTO> getPurchaseRequestDTOList(ArrayList<PurchaseRequest> purchaseRequests) {
        ArrayList<PurchaseRequestDTO> purchaseRequestsDTO = new ArrayList<>();
        for (PurchaseRequest purchaseRequest : purchaseRequests) {
            PurchaseRequestDTO purchaseRequestDTO = new PurchaseRequestDTO(
                    purchaseRequest.getUserName(),
                    getArticlesRequestDTO(purchaseRequest.getArticles())
            );
            purchaseRequestsDTO.add(purchaseRequestDTO);
        }
        return purchaseRequestsDTO;
    }

    private ArrayList<PurchaseArticleDTO> getArticlesRequestDTO(ArrayList<ArticleRequest> articlesRequest) {
        ArrayList<PurchaseArticleDTO> purchaseArticlesDTO = new ArrayList<>();
        for (ArticleRequest articleRequest : articlesRequest) {
            PurchaseArticleDTO purchaseArticleDTO = new PurchaseArticleDTO(
                    articleRequest.getProductId(),
                    articleRequest.getDiscount(),
                    articleRequest.getQuantity()
            );
            purchaseArticlesDTO.add(purchaseArticleDTO);
        }
        return purchaseArticlesDTO;
    }
}
