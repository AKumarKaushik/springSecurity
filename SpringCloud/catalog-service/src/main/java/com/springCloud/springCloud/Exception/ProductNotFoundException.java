package com.springCloud.springCloud.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ProductNotFoundException(Throwable throwable) {
        super(throwable);
    }

    public ProductNotFoundException(String message, Throwable throwable, boolean b, boolean b1) {
        super(message, throwable, b, b1);
    }
}
