package br.com.dearfuture.annotations.birthdate;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BirthDateSubsetValidator implements ConstraintValidator<BirthDateSubset, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null) return true;

        try{
            LocalDate date = LocalDate.parse(value);
            LocalDate today = LocalDate.now();

            Period period = Period.between(today, date);
            Integer years = Math.abs(period.getYears());

            if(years < 9){
                return false;
            }
            

            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
