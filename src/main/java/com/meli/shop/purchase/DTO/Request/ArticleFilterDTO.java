package com.meli.shop.purchase.DTO.Request;

public class ArticleFilterDTO {
    private String category;
    private String filter;
    private Integer order;

    public ArticleFilterDTO(String category, String filter, Integer order) {
        setCategory(category);
        setFilter(filter);
        setOrder(order);
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public ArticleFilterDTO() {
    }
}
