package com.meli.shop.purchase.API.v1.DTO.article;

import java.util.ArrayList;

public class ArticleFilterDTO {
    private String category;
    private ArrayList<String> filter;
    private Integer order;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<String> getFilter() {
        return filter;
    }

    public void setFilter(ArrayList<String> filter) {
        this.filter = filter;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ArticleFilterDTO(String category, ArrayList<String> filter, Integer order) {
        this.category = category;
        this.filter = filter;
        this.order = order;
    }

    public ArticleFilterDTO() {
    }
}
