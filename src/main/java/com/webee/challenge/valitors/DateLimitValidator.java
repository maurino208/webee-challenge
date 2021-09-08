package com.webee.challenge.valitors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateLimitValidator implements ConstraintValidator<DateLimitContraint, Date> {

    private Date dateLimit;

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext constraintValidatorContext) {

        if(value == null){
            return false;
        }
        if(dateLimit.before(value)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void initialize(DateLimitContraint constraintAnnotation) {
        this.dateLimit = constraintAnnotation.dateLimit;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
