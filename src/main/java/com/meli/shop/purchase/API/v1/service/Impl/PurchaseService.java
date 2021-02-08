package com.meli.shop.purchase.API.v1.service.Impl;

import com.meli.shop.purchase.API.v1.DTO.purchase.*;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.exception.article.InvalidArticles;
import com.meli.shop.purchase.API.v1.exception.article.InvalidPurchaseRequest;
import com.meli.shop.purchase.API.v1.exception.article.NoDataFoundException;
import com.meli.shop.purchase.API.v1.exception.article.NoStockException;
import com.meli.shop.purchase.API.v1.repository.IPurchaseRepository;
import com.meli.shop.purchase.API.v1.service.IPurchaseService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class PurchaseService implements IPurchaseService {
    private final IPurchaseRepository iPurchaseRepository;

    public PurchaseService(IPurchaseRepository iPurchaseRepository) {
        this.iPurchaseRepository = iPurchaseRepository;
    }

    @Override
    public PurchaseDTO sendPurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws Exception {
        return getPurchaseRequestReceipt(purchaseRequestDTO);
    }

    private PurchaseDTO getPurchaseRequestReceipt(PurchaseRequestDTO purchaseRequestDTO) throws IOException {
        ArrayList<ArticleResponseDTO> articles = new ArrayList<>();
        Double totalPrice = 0.0;

        if (purchaseRequestDTO == null) throw new InvalidPurchaseRequest();
        if (purchaseRequestDTO.getArticles() == null || purchaseRequestDTO.getArticles().isEmpty())
            throw new InvalidArticles();

        for (PurchaseArticleDTO article : purchaseRequestDTO.getArticles()) {
            ArticleResponseDTO articleResponseDTO = getArticleDTO(article);
            articles.add(articleResponseDTO);
            totalPrice += articleResponseDTO.getTotalPrice();
        }

        ReceiptDTO receiptDTO = new ReceiptDTO(String.valueOf(iPurchaseRepository.getLastId()), "PENDING", articles, totalPrice);
        PurchaseDTO purchaseDTO = new PurchaseDTO(receiptDTO, new StatusCodeDTO(200, "La petición de compra ha sido enviada con exito"));
        iPurchaseRepository.savePurchaseRequest(purchaseRequestDTO);
        return purchaseDTO;
    }

    @Override
    public PurchasesDTO getPurchaseRequestsPrice(UsernameDTO usernameDTO) throws Exception {
        ArrayList<PurchaseRequestDTO> purchasesDTO = iPurchaseRepository.getPurchaseRequestsByUserName(usernameDTO.getUsername());
        Double finalPrice = 0.0;
        ArrayList<PurchaseArticleDTO> articlesResponse = new ArrayList<>();
        ArrayList<PurchaseArticleDTO> articles;
        for (PurchaseRequestDTO purchaseDTO : purchasesDTO) {
            articles = purchaseDTO.getArticles();
            for (PurchaseArticleDTO article : articles) {
                ArticleDTO articleDTO = iPurchaseRepository.getArticleById(article.getProductId());
                finalPrice += calculatePrice(articleDTO.getPrice(), article.getQuantity(), article.getDiscount());
                articlesResponse.add(article);
            }
        }
        return new PurchasesDTO(articlesResponse, finalPrice);
    }

    private Double calculatePrice(Double price, Integer quantity, Integer discount) {
        Double totalPrice = price * quantity;
        return totalPrice - (totalPrice * discount / 100);
    }

    private ArticleResponseDTO getArticleDTO(PurchaseArticleDTO article) throws IOException {
        ArticleDTO articleDTO = iPurchaseRepository.getArticleById(article.getProductId());
        if (articleDTO == null) throw new NoDataFoundException();
        if (articleDTO.getStock() < article.getQuantity()) throw new NoStockException();

        Double price = calculatePrice(articleDTO.getPrice(), article.getQuantity(), article.getDiscount());
        return new ArticleResponseDTO(article.getProductId(), article.getDiscount(), article.getQuantity(), price);
    }

}
