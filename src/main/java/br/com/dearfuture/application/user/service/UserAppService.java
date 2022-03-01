package br.com.dearfuture.application.user.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import br.com.dearfuture.application.general.dto.ResponseCredentialsDto;
import br.com.dearfuture.application.user.dto.PostCreateUserDto;
import br.com.dearfuture.application.user.dto.PostUserAuthenticationDto;
import br.com.dearfuture.application.user.dto.PutUpdateUserDto;
import br.com.dearfuture.application.user.dto.ResponseUserAuthenticationDto;
import br.com.dearfuture.domain.user.entity.User;
import br.com.dearfuture.domain.user.repository.UserRepository;
import br.com.dearfuture.exceptions.EmailAlreadyInUseException;
import br.com.dearfuture.exceptions.UserNotFoundException;
import br.com.dearfuture.exceptions.UsernameAlreadyInUseException;
import br.com.dearfuture.utils.EntityMapper;
import br.com.dearfuture.utils.HeadersUtil;
import br.com.dearfuture.utils.JwtUtil;
import br.com.dearfuture.utils.PasswordUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAppService {
    
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public void postCreateUser(PostCreateUserDto postCreateUserDto){
        User user = new User();
        user.setName(postCreateUserDto.getName());
        user.setBirthDate(LocalDate.parse(postCreateUserDto.getBirthDate()));
        user.setUsername(postCreateUserDto.getUsername());
        user.setEmail(postCreateUserDto.getEmail());
        user.setPassword(PasswordUtil.encrypt(postCreateUserDto.getPassword()));
        this.userRepository.save(user);
    }
    
    public ResponseUserAuthenticationDto postUserAuthentication(PostUserAuthenticationDto postUserAuthenticationDto){
        User user = this.userRepository.getUserByEmailOrUsernameAndPassword(postUserAuthenticationDto.getAlias(), PasswordUtil.encrypt(postUserAuthenticationDto.getPassword())).orElseThrow();
        String token = jwtUtil.createJwtForClaims(user.getId(), user.getId(), null);

        ResponseUserAuthenticationDto responseUserAuthenticationDto = ResponseUserAuthenticationDto.builder()
                                                                                                    .jwtToken(token).build();
        return responseUserAuthenticationDto;
    }

    public void onBeforeUpdateUser(PutUpdateUserDto putUpdateUserDto, User user){
        this.userRepository.getUserByEmail(putUpdateUserDto.getEmail()).ifPresent((us) -> { if(!us.getId().equalsIgnoreCase(user.getId())) throw new EmailAlreadyInUseException(); });
        this.userRepository.getUserByUsername(putUpdateUserDto.getUsername()).ifPresent((us) -> { if(!us.getId().equalsIgnoreCase(user.getId())) throw new UsernameAlreadyInUseException(); });
    }

    public void putUpdateUser(PutUpdateUserDto putUpdateUserDto){
        ResponseCredentialsDto credentialsDto = HeadersUtil.decodeJwt();
        User user = this.userRepository.getUserById(credentialsDto.getUserId()).orElseThrow(UserNotFoundException::new);

        this.onBeforeUpdateUser(putUpdateUserDto, user);
        
        EntityMapper.copyNonNullProperties(putUpdateUserDto, user);
        this.userRepository.save(user);
    }

}
