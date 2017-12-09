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
    public PageBean<ExtMenu> findCostAllLimit(int pageNum, int pageSize) {
        /**
         * 1. 创建一个 pageBean 对象, pb
         * 2. 设置 pb 的 pc 和 ps
         * 3. 得到 tr, 设置给 pb
         * 4. 得到 beanList, 设置给 pb
         * 5. 返回 pb
         */
        PageBean<ExtMenu> pb = new PageBean<>();
        pb.setPageCode(pageNum);
        pb.setPageSize(pageSize);
        pb.setUrl("/fee/fee_list_findAll");

        // 得到 tr 总记录数
        List<ExtMenu> costAll = menuMapper.selectAll();
        int tr = costAll.size();
        pb.setTotalRecord(tr);

        pb.setStart((pageNum - 1) * pageSize);
        // 得到 BeanList, 10条数据 pc是变化得, limit 起始行 总行数
        List<ExtMenu> costAllLimit = menuMapper.findCostAllLimit(pb);
        /**
         * pc : 1 0-9
         * pc : 2 10-19
         * pc : 3 20-29
         */
        pb.setBeanList(costAllLimit);
        return pb;
    }

    @Override
    public List<Menu> findParent() {
        return menuMapper.findParent();
    }
}
