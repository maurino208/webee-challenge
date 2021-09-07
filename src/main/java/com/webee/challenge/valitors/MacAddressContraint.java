package com.webee.challenge.valitors;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//voy a crear una anotacion
@Documented
@Constraint(validatedBy = MacAddressValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface MacAddressContraint {

    String message() default "Invalid MAC Address";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
