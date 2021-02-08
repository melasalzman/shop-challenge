package com.meli.shop.purchase.API.v1.DTO.article;

import java.util.ArrayList;

public class ArticleFilterDTO {
    private String category;
    private ArrayList<String> filter;
    private Integer order;
    private String name;
    private String brand;
    private Integer quantity;
    private String shippingType;
    private Boolean featured;
    private Boolean arrivesTomorrow;
    private Boolean withoutInterest;
    private String condition;
    private Double expensivePricesThan;
    private Double cheaperPricesThan;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getShippingType() {
        return shippingType;
    }

    public void setShippingType(String shippingType) {
        if(shippingType==null){
            this.shippingType="NA";
        }else {
            this.shippingType = shippingType;
        }
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        if(featured==null){
            this.featured=false;
        }else {
            this.featured = featured;
        }
    }

    public Boolean getArrivesTomorrow() {
        return arrivesTomorrow;
    }

    public void setArrivesTomorrow(Boolean arrivesTomorrow) {
        if(arrivesTomorrow==null){
            this.arrivesTomorrow=false;
        }else {
            this.arrivesTomorrow = arrivesTomorrow;
        }
    }

    public Boolean getWithoutInterest() {
        return withoutInterest;
    }

    public void setWithoutInterest(Boolean withoutInterest) {
        if(withoutInterest==null){
            this.withoutInterest=false;
        }else {
            this.withoutInterest = withoutInterest;
        }
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        if(condition==null){
            this.condition="NA";
        }else {
            this.condition = condition;
        }
    }

    public Double getExpensivePricesThan() {
        return expensivePricesThan;
    }

    public void setExpensivePricesThan(Double expensivePricesThan) {
        this.expensivePricesThan = expensivePricesThan;
    }

    public Double getCheaperPricesThan() {
        return cheaperPricesThan;
    }

    public void setCheaperPricesThan(Double cheaperPricesThan) {
        this.cheaperPricesThan = cheaperPricesThan;
    }

    public ArticleFilterDTO(String category, ArrayList<String> filter, Integer order, String name, String brand,
                            Integer quantity, String shippingType, Boolean featured, Boolean arrivesTomorrow,
                            Boolean withoutInterest, String condition, Double expensivePricesThan,
                            Double cheaperPricesThan) {
        this.category = category;
        this.filter = filter;
        this.order = order;
        this.name = name;
        this.brand = brand;
        this.quantity = quantity;
        this.shippingType = shippingType;
        this.featured = featured;
        this.arrivesTomorrow = arrivesTomorrow;
        this.withoutInterest = withoutInterest;
        this.condition = condition;
        this.expensivePricesThan = expensivePricesThan;
        this.cheaperPricesThan = cheaperPricesThan;
    }

    public ArticleFilterDTO() {
    }
}
