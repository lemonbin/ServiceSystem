package com.baidu.menu.service.impl;

import com.baidu.menu.domain.Menu;
import com.baidu.menu.mapper.MenuMapper;
import com.baidu.menu.service.MenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 2017/12/6.
 */
@Service
public class MenuServiceImpl implements MenuService{
    @Resource
    public MenuMapper menuMapper;
    @Override
    public List<Menu> selectAll() {
        return menuMapper.selectAll();
    }
}
