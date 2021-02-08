package com.meli.shop.purchase.API.v1.service;

import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseRequestDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchaseDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.PurchasesDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.UsernameDTO;

public interface IPurchaseService {
    PurchaseDTO sendPurchaseRequest(PurchaseRequestDTO purchaseRequestDTO) throws Exception;

    PurchasesDTO getPurchaseRequestsPrice(UsernameDTO usernameDTO) throws Exception;
}
