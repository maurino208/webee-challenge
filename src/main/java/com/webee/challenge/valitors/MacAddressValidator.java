package com.webee.challenge.valitors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MacAddressValidator implements ConstraintValidator<MacAddressContraint, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.matches("^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$");
    }

    @Override
    public void initialize(MacAddressContraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
