package com.baidu.menu.service.impl;

import com.baidu.base.utils.PageBean;
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

    //分页
    public PageInfo<ExtMenu> queryPage(Integer pageNum, Integer PagSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        PagSize = PagSize == null ? 3 : PagSize;
//
        PageHelper.startPage(pageNum, PagSize);

        List<ExtMenu> all = menuMapper.selectAll();
        PageInfo<ExtMenu> pageInfo = new PageInfo<ExtMenu>(all);
        return pageInfo;
    }

    @Override
    public List<ExtMenu> findAll() {
        return menuMapper.selectAll();
    }

    @Override
    public Menu findById(int parent_id) {
        return menuMapper.findById(parent_id);
    }
    

    @Override
    public List<Menu> findParent() {
        return menuMapper.findParent();
    }

    @Override
    public int insert(Menu menu) {
        return menuMapper.insert(menu);
    }

    @Override
    public List<Menu> selectAllMenu(int parent_id) {
        return menuMapper.selectAllMenu(parent_id);
    }

    @Override
    public int update(Menu menu) {
        return menuMapper.update(menu);
    }

}
