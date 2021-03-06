package com.baidu.user.service.impl;

import com.baidu.user.domain.User;
import com.baidu.user.domain.ext.ExtUser;
import com.baidu.user.mapper.UserMapper;
import com.baidu.user.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }
    public PageInfo<User> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        return pageInfo;
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delById(Integer id) {
        userMapper.delById(id);
    }

    @Override
    public boolean datadel(String del) {
        String[] split = del.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                int i1 = Integer.parseInt(split[i]);
                userMapper.delById(i1);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public PageInfo<User> fuzzyQueryPage(ExtUser extUser, Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<User> all = userMapper.fuzzyFindAll(extUser);

        PageInfo<User> rolePageInfo = new PageInfo<User>(all);

        return rolePageInfo;
    }
}
