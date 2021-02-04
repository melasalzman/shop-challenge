package com.meli.shop.purchase.service;

import com.meli.shop.purchase.DTO.Request.PurchaseRequestDTO;
import com.meli.shop.purchase.DTO.Response.PurchaseDTO;

import java.io.IOException;

public interface IPurchaseService {
    PurchaseDTO sendPurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws Exception;

    PurchaseDTO getPurchaseRequestsPrice() throws Exception;
}
