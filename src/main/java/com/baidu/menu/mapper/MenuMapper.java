package com.baidu.menu.mapper;

import com.baidu.base.utils.PageBean;
import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;

import java.util.List;

/**
 * Created by dllo on 2017/12/6.
 */
public interface MenuMapper {

    List<ExtMenu> selectAll();

    Menu findById(int parent_id);

    List<ExtMenu> findCostAllLimit(PageBean<ExtMenu> pb);

    List<Menu> findParent();
}
