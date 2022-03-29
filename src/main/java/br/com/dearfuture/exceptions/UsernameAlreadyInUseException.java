package br.com.dearfuture.exceptions;

import org.springframework.http.HttpStatus;

public class UsernameAlreadyInUseException extends CustomException {
    private final String message = "Este nome de usuário já está em uso";
    private final String code = "USER_NOT_FOUND";

    public UsernameAlreadyInUseException(){
        this.setMessage(message);
        this.setCode(code);
        this.setStatus(HttpStatus.NOT_FOUND);
    }  
}
