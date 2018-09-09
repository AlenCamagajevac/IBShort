package com.ibshort.url.validator;

import com.ibshort.url.model.RedirectType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CorrectRedirectTypeValidator implements ConstraintValidator<CorrectRedirectType, Integer> {

    @Override
    public boolean isValid(Integer redirectType, ConstraintValidatorContext constraintValidatorContext) {
        try {
            RedirectType.fromValue(redirectType);
            return true;
        } catch (IllegalArgumentException ex) {
            return false;
        }
    }
}
