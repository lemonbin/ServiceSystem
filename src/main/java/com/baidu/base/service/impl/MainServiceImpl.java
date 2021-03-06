package com.baidu.base.service.impl;

import com.baidu.base.domain.IPAddress;
import com.baidu.base.mapper.MainMapper;
import com.baidu.base.service.MainService;
import com.baidu.user.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Service
public class MainServiceImpl implements MainService{

    @Resource
    private MainMapper mainMapper;

    @Override
    public User findByUsername(String username) {
        return mainMapper.findByUsername(username);
    }

    @Override
    public User findSingle(User user1) {
        return mainMapper.findSingle(user1);
    }

    @Override
    public void updatePassword(User user) {
        mainMapper.updatePassword(user);
    }

    @Override
    public List<IPAddress> findIP() {
        return mainMapper.findIP();
    }
}
