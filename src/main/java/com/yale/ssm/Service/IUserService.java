package com.yale.ssm.Service;

import com.yale.ssm.entity.User;

import java.util.List;

public interface IUserService {
    List<User> getUserList(int offset, int limit);
}
