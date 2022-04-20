package com.amsidh.mvc;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonDtoValidator implements ConstraintValidator<PersonDtoValidator, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        return true;

    }
}
