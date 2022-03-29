package br.com.dearfuture.config;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import br.com.dearfuture.domain.user.entity.User;
import br.com.dearfuture.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AuthenticateUserBean {
    private final UserRepository userRepository;

    @Bean
    public Function<SecurityContext, User> fetchUser() {
        
        return (context -> {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            User user = this.userRepository.getUserById(name).orElse(null);
            return user;
        });
    }

}
