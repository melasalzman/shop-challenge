package com.meli.shop.purchase.API.v1.DTO.purchase;

import java.util.ArrayList;

public class PurchasesDTO {
    private ArrayList<PurchaseArticleDTO> articles;
    private Double finalPrice;

    public ArrayList<PurchaseArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<PurchaseArticleDTO> articles) {
        this.articles = articles;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public PurchasesDTO(ArrayList<PurchaseArticleDTO> articles, Double finalPrice) {
        this.articles = articles;
        this.finalPrice = finalPrice;
    }

    public PurchasesDTO() {
    }
}
