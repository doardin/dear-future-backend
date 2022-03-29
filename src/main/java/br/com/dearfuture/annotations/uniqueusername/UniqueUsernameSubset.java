package br.com.dearfuture.annotations.uniqueusername;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UniqueUsernameSubsetValidator.class)
public @interface UniqueUsernameSubset {
    
    String message() default "Este nome de usuário já está em uso";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
