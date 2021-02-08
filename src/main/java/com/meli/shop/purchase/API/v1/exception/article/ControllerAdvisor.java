package com.meli.shop.purchase.API.v1.exception.article;

import com.meli.shop.purchase.API.v1.DTO.ResponseDTO;
import com.meli.shop.purchase.API.v1.DTO.purchase.StatusCodeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ResponseDTO<Object>> handleNodataFoundException(NoDataFoundException ex, WebRequest request) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(null, new StatusCodeDTO(404, ex.getMessage()));
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidArticles.class)
    public ResponseEntity<ResponseDTO<Object>> handleInvalidArticles(InvalidArticles ex, WebRequest request) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(null, new StatusCodeDTO(404, ex.getMessage()));
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidPurchaseRequest.class)
    public ResponseEntity<ResponseDTO<Object>> handleInvalidPurchaseRequest(InvalidPurchaseRequest ex, WebRequest request) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(null, new StatusCodeDTO(404, ex.getMessage()));
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoStockException.class)
    public ResponseEntity<ResponseDTO<Object>> handleNoStockException(NoStockException ex, WebRequest request) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(null, new StatusCodeDTO(404, ex.getMessage()));
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ResponseDTO<Object>> handleAlreadyExistException(AlreadyExistException ex, WebRequest request) {
        ResponseDTO<Object> responseDTO = new ResponseDTO<>(null, new StatusCodeDTO(404, ex.getMessage()));
        return new ResponseEntity<>(responseDTO, HttpStatus.NOT_FOUND);
    }
}
