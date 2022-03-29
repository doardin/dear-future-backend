package br.com.dearfuture.presentation;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.dearfuture.annotations.authenticateduser.AuthenticateUser;
import br.com.dearfuture.application.user.dto.PostCreateUserDto;
import br.com.dearfuture.application.user.dto.PostUserAuthenticationDto;
import br.com.dearfuture.application.user.dto.PutUpdateUserDto;
import br.com.dearfuture.application.user.dto.ResponseUserAuthenticationDto;
import br.com.dearfuture.application.user.service.UserAppService;
import br.com.dearfuture.domain.user.entity.User;
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
    public ResponseEntity<ResponseUserAuthenticationDto> postUserAuthentication(@RequestBody @Valid PostUserAuthenticationDto postUserAuthenticationDto){
        ResponseUserAuthenticationDto responseUserAuthenticationDto = this.userAppService.postUserAuthentication(postUserAuthenticationDto);
        return ResponseEntity.ok(responseUserAuthenticationDto);
    }

    @PutMapping("/user")
    public ResponseEntity<?> putUpdateUser(@RequestBody @Valid PutUpdateUserDto putUpdateUserDto, @AuthenticateUser User user){
        this.userAppService.putUpdateUser(putUpdateUserDto, user);
        return ResponseEntity.ok().build();
    }

}
