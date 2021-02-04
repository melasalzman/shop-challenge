package com.meli.shop.purchase.Model;

import java.util.ArrayList;

public class PurchaseRequest {
    private String userName;
    private ArrayList<ArticleRequest> articles;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<ArticleRequest> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ArticleRequest> articles) {
        this.articles = articles;
    }

    public PurchaseRequest(String userName, ArrayList<ArticleRequest> articles) {
        this.userName = userName;
        this.articles = articles;
    }

    public PurchaseRequest() {
    }
}
