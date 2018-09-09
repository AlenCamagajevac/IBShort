package com.ibshort.url.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CorrectRedirectTypeValidator.class)
public @interface CorrectRedirectType {

    String message() default "Redirect type should be 301 or 302";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
