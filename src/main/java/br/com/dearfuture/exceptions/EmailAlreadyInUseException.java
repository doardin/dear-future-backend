package br.com.dearfuture.exceptions;

import org.springframework.http.HttpStatus;

public class EmailAlreadyInUseException extends CustomException {
    private final String message = "Este email já está em uso";
    private final String code = "USER_NOT_FOUND";

    public EmailAlreadyInUseException(){
        this.setMessage(message);
        this.setCode(code);
        this.setStatus(HttpStatus.NOT_FOUND);
    }  
}
