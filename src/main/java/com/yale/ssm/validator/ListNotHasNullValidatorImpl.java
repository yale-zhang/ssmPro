package com.yale.ssm.validator;

import com.yale.ssm.validator.annotation.ListNotHasNull;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Service
public class ListNotHasNullValidatorImpl implements ConstraintValidator<ListNotHasNull,List> {

    private int value;

    @Override
    public void initialize(ListNotHasNull listNotHasNull) {
        //传入value值，可以在校验中使用
        this.value =  listNotHasNull.value();
    }
    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        for (Object obj:list){
            if (obj == null){
                //如果List集合中含有Null元素，校验失败
                return false;
            }
        }
        return true;
    }
}
