package com.baidu.menu.service;

import com.baidu.menu.domain.Menu;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by dllo on 2017/12/6.
 */
public interface MenuService {
    PageInfo<Menu> queryPage(Integer info, Integer pageNum, Integer PagSize);
}
