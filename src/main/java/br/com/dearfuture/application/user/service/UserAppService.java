package br.com.dearfuture.application.user.service;

import org.springframework.stereotype.Service;

import br.com.dearfuture.application.user.dto.PostCreateUserDto;
import br.com.dearfuture.application.user.dto.PostUserAuthenticationDto;
import br.com.dearfuture.domain.user.entity.User;
import br.com.dearfuture.domain.user.repository.UserRepository;
import br.com.dearfuture.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAppService {
    
    private final UserRepository userRepository;

    public void postCreateUser(PostCreateUserDto postCreateUserDto){
        User user = new User();
        user.setName(postCreateUserDto.getName());
        user.setBirthDate(postCreateUserDto.getBirthDate());
        user.setUsername(postCreateUserDto.getUsername());
        user.setEmail(postCreateUserDto.getEmail());
        user.setPassword(PasswordUtil.encrypt(postCreateUserDto.getPassword()));
        this.userRepository.save(user);
    }
    
    public void postUserAuthentication(PostUserAuthenticationDto postUserAuthenticationDto){
        User user = this.userRepository.getByEmailOrUsernameAndPassword(postUserAuthenticationDto.getAlias(), PasswordUtil.encrypt(postUserAuthenticationDto.getPassword())).orElseThrow();
        System.out.println(user.getEmail());
    }

}
