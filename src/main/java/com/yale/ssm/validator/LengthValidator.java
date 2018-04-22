package com.yale.ssm.validator;

import com.yale.ssm.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LengthValidator<T extends User> implements IValidator<T>{

    @Override
    public void validate(T user) {

    }


   /* public static String lengthLimit(String source, String arg, int max) {
        if (StringUtils.isNotBlank(source) && source.trim().length() > max) {
            throw new BusinessException(String.format("[%s]长度超出了限制,最大为:%s", arg, max));
        } else {
            return source;
        }
    }

    public static BigDecimal lengthLimit(BigDecimal source, String arg, BigDecimal max) {
        if (source != null && max != null) {
            if (source.compareTo(max) == 1) {
                throw new BusinessException(String.format("[%s]长度超出了限制,最大为:%s", arg, max));
            } else {
                return source;
            }
        } else {
            return source;
        }
    }*/
}
