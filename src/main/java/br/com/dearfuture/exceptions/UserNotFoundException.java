package br.com.dearfuture.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends CustomException {
    private final String message = "Usuário não encontrado";
    private final String code = "USER_NOT_FOUND";

    public UserNotFoundException(){
        this.setMessage(message);
        this.setCode(code);
        this.setStatus(HttpStatus.NOT_FOUND);
    }    
}
