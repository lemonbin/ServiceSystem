package com.baidu.menu.service.impl;

import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;
import com.baidu.menu.mapper.MenuMapper;
import com.baidu.menu.service.MenuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 2017/12/6.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Resource
    public MenuMapper menuMapper;

//    //分页
//    public PageInfo<Menu> queryPage(Integer pageNum, Integer PagSize) {
//        pageNum = pageNum == null ? 1 : pageNum;
//        PagSize = PagSize == null ? 3 : PagSize;
////
//        PageHelper.startPage(pageNum, PagSize);
//
//        List<Menu> all = menuMapper.selectAll();
//        PageInfo<Menu> pageInfo = new PageInfo<>(all);
//        return pageInfo;
//    }

    @Override
    public List<ExtMenu> findAll() {
        return menuMapper.selectAll();
    }

    @Override
    public Menu findById(int parent_id) {
        return menuMapper.findById(parent_id);
    }
}
