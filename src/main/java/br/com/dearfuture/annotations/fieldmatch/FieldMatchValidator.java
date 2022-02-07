package br.com.dearfuture.annotations.fieldmatch;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatchSubset, Object> {
    
    private String firstField;
	private String secondField;
	private String message;
	
	@Override
	public void initialize(final FieldMatchSubset constraint) {
		this.firstField = constraint.first();
		this.secondField = constraint.second();
		this.message = constraint.message();
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean isValid = false;
		
		try {
			final Object firstObject = BeanUtils.getProperty(value, this.firstField);
			final Object secondObject = BeanUtils.getProperty(value, this.secondField);
			
			isValid = firstObject == null && secondObject == null || firstObject != null && firstObject.equals(secondObject);
		}
		catch(final Exception ignore) {}
		
		if (!isValid) {
			context.buildConstraintViolationWithTemplate(this.message)
			.addPropertyNode(this.firstField)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		}
		
		return isValid;
	}


}
