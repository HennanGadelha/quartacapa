package com.quartacapa.config.exceptions;

import org.springframework.http.HttpStatus;

public class EntidadeJaExistenteException  extends Throwable {


    private HttpStatus status;
    private String message;


    public EntidadeJaExistenteException(HttpStatus  status, String message) {
        super(message);
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

}
