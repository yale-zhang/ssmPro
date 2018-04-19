package com.yale.ssm.validator;

import com.yale.ssm.validator.annotation.Not999;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Not999Validator implements ConstraintValidator<Not999,Long> {
    @Override
    public void initialize(Not999 not999) {

    }

    @Override
    public boolean isValid(Long aLong, ConstraintValidatorContext context) {
        if(aLong==999) {
            return false;
        }else {
            return true;
        }
    }
}
