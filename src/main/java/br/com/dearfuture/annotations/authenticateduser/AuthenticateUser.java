package br.com.dearfuture.annotations.authenticateduser;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.springframework.security.core.annotation.CurrentSecurityContext;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@CurrentSecurityContext(expression = "@fetchUser.apply(#this)", errorOnInvalidType = true)
public @interface AuthenticateUser {
    
}
