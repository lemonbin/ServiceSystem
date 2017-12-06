package com.baidu.base.mapper;

import com.baidu.user.domain.User;

/**
 * Created by dllo on 17/12/5.
 */
public interface MainMapper {

    User findByUserName(String username);

    User findSingle(User user1);
}
