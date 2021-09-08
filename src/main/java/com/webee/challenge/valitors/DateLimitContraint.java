package com.webee.challenge.valitors;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//voy a crear una anotacion
@Documented
@Constraint(validatedBy = DateLimitValidator.class)
@Target( { ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface DateLimitContraint {

    String message() default "Date Limit Excedeed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Date dateLimit = new GregorianCalendar(2019, 11, 31).getTime();
    /*
    Date value();
    @Target({ ElementType.FIELD })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateLimitContraint[] value();
    }
     */

}
