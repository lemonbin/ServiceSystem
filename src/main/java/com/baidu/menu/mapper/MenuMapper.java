package com.baidu.menu.mapper;

import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;

import java.util.List;

/**
 * Created by dllo on 2017/12/6.
 */
public interface MenuMapper {

    List<ExtMenu> selectAll();

    Menu findById(int parent_id);

    List<Menu> findParent();

    int insert(Menu menu);

    List<Menu> selectAllMenu(int parent_id);

    int update(Menu menu);
}
