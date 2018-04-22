package com.yale.ssm.validator;

import com.yale.ssm.entity.User;
import org.springframework.stereotype.Service;

@Service
public class LengthValidator<T extends User> implements IValidator<T>{

    @Override
    public void validate(T user) {

    }
}
