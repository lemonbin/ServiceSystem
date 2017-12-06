package com.baidu.menu.service;

import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by dllo on 2017/12/6.
 */
public interface MenuService {
//    PageInfo<Menu> queryPage(Integer pageNum, Integer PagSize);

    List<ExtMenu> findAll();

    Menu findById(int parent_id);
}
