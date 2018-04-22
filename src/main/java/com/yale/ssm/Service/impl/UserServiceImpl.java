package com.yale.ssm.Service.impl;

import com.yale.ssm.Service.IUserService;
import com.yale.ssm.entity.User;
import com.yale.ssm.validator.IValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource(name = "generalBatchValidators")
    private List<IValidator> validators;

    @Override
    public List<User> getUserList(int offset, int limit) {
      //校验组
      /*  for (IValidator validator : validators) {
            validator.validate(record);
        }*/
        return null;
    }
}
