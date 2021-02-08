package com.meli.shop.purchase.API.v1.DTO.purchase;

import java.util.ArrayList;

public class ReceiptDTO {
    private String id;
    private String status;
    private ArrayList<ArticleResponseDTO> articles;
    private Double totalPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<ArticleResponseDTO> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleResponseDTO> articles) {
        this.articles = articles;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ReceiptDTO(String id, String status, ArrayList<ArticleResponseDTO> articles, Double totalPrice) {
        this.id = id;
        this.status = status;
        this.articles = articles;
        this.totalPrice = totalPrice;
    }

    public ReceiptDTO() {
    }
}
