package br.com.springrest.controller;

import br.com.springrest.exception.ProductNullException;
import br.com.springrest.exception.ProductPriceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ProdutoControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNullException.class)
    public ResponseEntity<Object> capturaErroNull() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Verifique os campos do produto");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(ProductPriceException.class)
    public ResponseEntity<Object> capturaErroPreco() {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "preço do produto não pode ser negativo");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
