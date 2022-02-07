package br.com.dearfuture.presentation;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dearfuture.application.user.dto.PostCreateUserDto;
import br.com.dearfuture.application.user.dto.PostUserAuthenticationDto;
import br.com.dearfuture.application.user.service.UserAppService;
import lombok.RequiredArgsConstructor;

@RestController
@Validated
@RequiredArgsConstructor
public class UserController {
    
    private final UserAppService userAppService;

    @PostMapping("/user/sign-up")
    public ResponseEntity<?> postCreateUser(@RequestBody @Valid PostCreateUserDto postCreateUserDto){
        this.userAppService.postCreateUser(postCreateUserDto);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/user/sign-in")
    public ResponseEntity<?> postUserAuthentication(@RequestBody @Valid PostUserAuthenticationDto postUserAuthenticationDto){
        this.userAppService.postUserAuthentication(postUserAuthenticationDto);
        return ResponseEntity.ok().build();
    }

}
