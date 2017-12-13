package com.baidu.user.service;

import com.baidu.user.domain.User;
import com.baidu.user.domain.ext.ExtUser;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface UserService {
    List<User> getAllUser();
    PageInfo<User> queryPage(Integer pageNum, Integer pageSize);

    void addUser(User user);

    void delById(Integer id);

    boolean datadel(String del);

    PageInfo<User> fuzzyQueryPage(ExtUser extUser, Integer pageNum, Integer pageSize);
}
