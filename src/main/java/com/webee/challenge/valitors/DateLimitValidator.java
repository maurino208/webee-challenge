package com.webee.challenge.valitors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateLimitValidator implements ConstraintValidator<DateLimitContraint, Date> {

    private Date date;

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext constraintValidatorContext) {

        if(value == null){
            return false;
        }
        if(date.before(value)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void initialize(DateLimitContraint constraintAnnotation) {
        this.date = constraintAnnotation.dateLimit;
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
