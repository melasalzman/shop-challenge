package com.meli.shop.purchase.API.v1.service;

import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseRequestDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseDTO;

public interface IPurchaseService {
    PurchaseDTO sendPurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws Exception;

    PurchaseDTO getPurchaseRequestsPrice() throws Exception;
}
