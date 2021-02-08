package com.meli.shop.purchase.API.v1.DTO.purchase;

public class PurchaseDTO {
    private ReceiptDTO receipt;
    private StatusCodeDTO statusCode;

    public ReceiptDTO getReceipt() {
        return receipt;
    }

    public void setReceipt(ReceiptDTO receipt) {
        this.receipt = receipt;
    }

    public StatusCodeDTO getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCodeDTO statusCode) {
        this.statusCode = statusCode;
    }

    public PurchaseDTO(ReceiptDTO receipt, StatusCodeDTO statusCode) {
        this.receipt = receipt;
        this.statusCode = statusCode;
    }

    public PurchaseDTO() {
    }
}
