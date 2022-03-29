package br.com.dearfuture.annotations.uniqueusername;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.dearfuture.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameSubsetValidator implements ConstraintValidator<UniqueUsernameSubset, String> {
    
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value == null) return true;
        return this.userRepository.getUserByUsername(value).isEmpty();
    }

}
