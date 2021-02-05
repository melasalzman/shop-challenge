package com.meli.shop.purchase.API.v1.service.Impl;

import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseRequestDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseArticleDTO;
import com.meli.shop.purchase.API.v1.DTO.article.ArticleDTO;
import com.meli.shop.purchase.API.v1.repository.IPurchaseRepository;
import com.meli.shop.purchase.API.v1.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PurchaseService implements IPurchaseService {
    @Autowired
    private IPurchaseRepository iPurchaseRepository;

    @Override
    public PurchaseDTO sendPurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws Exception {
        iPurchaseRepository.savePurchaseRequest(purchaseRequestDTO);
        return new PurchaseDTO(calculatePurchaseRequestPrice(purchaseRequestDTO.getArticles()));
    }

    @Override
    public PurchaseDTO getPurchaseRequestsPrice() throws Exception {
        ArrayList<PurchaseRequestDTO> purchaseRequestDTO = iPurchaseRepository.getAllPurchaseRequest();
        return new PurchaseDTO(calculateAllPurchaseRequestPrice(purchaseRequestDTO));
    }

    private Double calculatePurchaseRequestPrice(ArrayList<PurchaseArticleDTO> articles) throws Exception {
        double totalPrice = 0;
        for (PurchaseArticleDTO article : articles) {
            ArticleDTO articleDTO = iPurchaseRepository.getArticleById(article.getProductId());
            if(articleDTO.getStock()>=article.getQuantity()){
                Double articlesTotalPrice = article.getQuantity() * articleDTO.getPrice();
                Double articlesDiscount = articlesTotalPrice * article.getDiscount() / 100;
                totalPrice += articlesTotalPrice - articlesDiscount;
            } else{
                throw new Exception("No hay stock");
            }
        }
        return totalPrice;
    }

    private Double calculateAllPurchaseRequestPrice(ArrayList<PurchaseRequestDTO> purchaseRequests) throws Exception {
        double totalPrice = 0;
        for (PurchaseRequestDTO purchaseRequest : purchaseRequests) {
            totalPrice += calculatePurchaseRequestPrice(purchaseRequest.getArticles());
        }
        return totalPrice;
    }
}
