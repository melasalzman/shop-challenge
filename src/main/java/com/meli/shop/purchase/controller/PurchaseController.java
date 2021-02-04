package com.meli.shop.purchase.controller;
import com.meli.shop.purchase.DTO.Request.PurchaseRequestDTO;
import com.meli.shop.purchase.DTO.Request.ArticleFilterDTO;
import com.meli.shop.purchase.DTO.Response.ArticleDTO;
import com.meli.shop.purchase.DTO.Response.PurchaseDTO;
import com.meli.shop.purchase.service.IArticlesService;
import com.meli.shop.purchase.service.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PurchaseController {
    /*Hacer como constructor*/
    @Autowired
    private IPurchaseService iPurchaseService;

    @PostMapping("/api/v1/purchase-request")
    public PurchaseDTO sendPurchaseRequest(@RequestBody PurchaseRequestDTO purchaseRequestDTO) throws Exception {
        return iPurchaseService.sendPurchaseRequest(purchaseRequestDTO);
    }

    @GetMapping("/api/v1/purchase-request/final-price")
    public PurchaseDTO getPurchaseRequestsPrice() throws Exception {
        return iPurchaseService.getPurchaseRequestsPrice();
    }
}
