package com.meli.shop.purchase.API.v1.repository;

import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseRequestDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IPurchaseRepository {
    ArticleDTO getArticleById(Integer productId) throws IOException;

    void savePurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws IOException;

    ArrayList<PurchaseRequestDTO> getAllPurchaseRequest() throws IOException;
}
