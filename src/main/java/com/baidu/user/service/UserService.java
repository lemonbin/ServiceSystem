package com.baidu.user.service;

import com.baidu.user.domain.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface UserService {
    List<User> getAllUser();
    PageInfo<User> queryPage(Integer pageNum, Integer pageSize);

    void addUser(User user);
}
