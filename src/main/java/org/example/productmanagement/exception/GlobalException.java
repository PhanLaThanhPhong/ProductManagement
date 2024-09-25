package org.example.productmanagement.exception;

import org.example.productmanagement.domain.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(value = IdInvalidException.class)
    public ResponseEntity<RestResponse<Object>> handleIdException(IdInvalidException idInvalidException) {
        RestResponse<Object> restResponse = new RestResponse<>();
        restResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        restResponse.setMessage("IdInvalidException");
        restResponse.setError(idInvalidException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(restResponse);
    }
}
