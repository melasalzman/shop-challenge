package com.meli.shop.purchase.repository;

import com.meli.shop.purchase.DTO.Request.PurchaseRequestDTO;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;

import java.io.IOException;
import java.util.ArrayList;

public interface IPurchaseRepository {
    ArticleDTO getArticleById(Integer productId) throws IOException;

    void savePurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws IOException;

    ArrayList<PurchaseRequestDTO> getAllPurchaseRequest() throws IOException;
}
