package com.baidu.base.mapper;

import com.baidu.base.domain.IPAddress;
import com.baidu.user.domain.User;

import java.util.List;

/**
 * Created by dllo on 17/12/5.
 */
public interface MainMapper {

    User findByUsername(String username);

    User findSingle(User user1);

    void updatePassword(User user);

    List<IPAddress> findIPCount();

    void save(IPAddress ipAddress);
}
