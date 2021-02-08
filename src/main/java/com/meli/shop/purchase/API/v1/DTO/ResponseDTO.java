package com.meli.shop.purchase.API.v1.DTO;

import com.meli.shop.purchase.API.v1.DTO.purchase.StatusCodeDTO;

public class ResponseDTO<T> {
    private T object;
    private StatusCodeDTO statusCodeDTO;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public StatusCodeDTO getStatusCodeDTO() {
        return statusCodeDTO;
    }

    public void setStatusCodeDTO(StatusCodeDTO statusCodeDTO) {
        this.statusCodeDTO = statusCodeDTO;
    }

    public ResponseDTO(T object, StatusCodeDTO statusCodeDTO) {
        this.object = object;
        this.statusCodeDTO = statusCodeDTO;
    }

    public ResponseDTO() {
    }
}
