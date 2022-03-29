package br.com.dearfuture.annotations.uniqueemail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.dearfuture.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueEmailSubsetValidator implements ConstraintValidator<UniqueEmailSubset, String> {
    
    private final UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        if(value == null) return true;
        return this.userRepository.getUserByEmail(value).isEmpty();
    }

}
