package com.baidu.menu.service.impl;

import com.baidu.menu.domain.Menu;
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
public class MenuServiceImpl implements MenuService{
    @Resource
    public MenuMapper menuMapper;

    //分页 +排序
    public PageInfo<Menu> queryPage(Integer info,Integer pageNum, Integer PagSize) {
        pageNum = pageNum == null ? 1 : pageNum;
        PagSize = PagSize == null ? 3 : PagSize;

        if (info ==0){
            PageHelper.startPage(pageNum, PagSize);
        }
        if (info ==1 ) {
            PageHelper.startPage(pageNum, PagSize, "base_cost desc");
        }
        if (info ==2) {
            PageHelper.startPage(pageNum, PagSize, "base_cost asc");
        }
        if (info==3) {
            PageHelper.startPage(pageNum, PagSize, "base_duration desc");
        }
        if (info==4) {
            PageHelper.startPage(pageNum, PagSize, "base_duration asc");
        }

        List<Menu> all = menuMapper.selectAll();
        PageInfo<Menu> pageInfo = new PageInfo<Menu>(all);

        return pageInfo;
    }
}
