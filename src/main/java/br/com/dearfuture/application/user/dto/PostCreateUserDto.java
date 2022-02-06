package br.com.dearfuture.application.user.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreateUserDto {
    private String name;
    private LocalDate birthDate;
    private String username;
    private String email;
    private String password;
    private String passwordConfirmation;
}
