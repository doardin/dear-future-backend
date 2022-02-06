package br.com.dearfuture.application.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostUserAuthenticationDto {
    private String alias;
    private String password;
}
