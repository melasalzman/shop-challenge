package com.meli.shop.purchase.DTO.Request;

import java.util.ArrayList;

public class PurchaseRequestDTO {
    private String userName;
    private ArrayList<PurchaseArticleDTO> articles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<PurchaseArticleDTO> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<PurchaseArticleDTO> articles) {
        this.articles = articles;
    }

    public PurchaseRequestDTO(String userName, ArrayList<PurchaseArticleDTO> articles) {
        this.userName = userName;
        this.articles = articles;
    }

    public PurchaseRequestDTO() {
    }

    @Override
    public String toString() {
        return "PurchaseRequestDTO{" +
                "userName='" + userName + '\'' +
                ", articles=" + articles +
                '}';
    }
}
