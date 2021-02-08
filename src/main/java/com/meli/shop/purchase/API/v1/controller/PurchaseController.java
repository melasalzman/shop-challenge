package com.meli.shop.purchase.API.v1.controller;

import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseRequestDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchasesDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.UsernameDTO;
import com.meli.shop.purchase.API.v1.service.IPurchaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PurchaseController {
    private final IPurchaseService iPurchaseService;

    public PurchaseController(IPurchaseService iPurchaseService) {
        this.iPurchaseService = iPurchaseService;
    }

    @PostMapping("/purchase-request")
    public PurchaseDTO sendPurchaseRequest(@RequestBody PurchaseRequestDTO purchaseRequestDTO) throws Exception {
        return iPurchaseService.sendPurchaseRequest(purchaseRequestDTO);
    }

    @GetMapping("/purchase-request/final-price")
    public PurchasesDTO getAllPurchaseRequestPriceByUser(UsernameDTO usernameDTO) throws Exception {
        return iPurchaseService.getPurchaseRequestsPrice(usernameDTO);
    }
}
