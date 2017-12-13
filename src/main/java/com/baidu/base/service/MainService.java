package com.baidu.base.service;

import com.baidu.base.domain.IPAddress;
import com.baidu.user.domain.User;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface MainService {

    User findByUsername(String username);

    User findSingle(User user1);

    void updatePassword(User user);

    List<IPAddress> findIP();
}
