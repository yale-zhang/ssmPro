package com.yale.ssm.validator;

import com.yale.ssm.entity.User;

public interface IValidator<T extends User> {
    void validate(T invoice);
}
