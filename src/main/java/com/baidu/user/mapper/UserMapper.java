package com.baidu.user.mapper;

import com.baidu.user.domain.User;
import com.baidu.user.domain.ext.ExtUser;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface UserMapper {
    List<User> getAllUser();
    User selectById(Integer id);

    List<User> findAll();

    void addUser(User user);

    void delById(Integer id);

    List<User> fuzzyFindAll(ExtUser extUser);
}
