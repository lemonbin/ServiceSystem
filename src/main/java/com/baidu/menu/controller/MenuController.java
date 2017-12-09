package com.baidu.menu.controller;

import com.baidu.base.utils.AjaxResult;
import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;
import com.baidu.menu.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by dllo on 2017/12/6.
 */
@Controller
public class MenuController {
    @Resource
    private MenuService menuService;

    //分页+查询所有
//    @ResponseBody
//    @RequestMapping("/pageAll")
//    public PageBean<ExtMenu> pageAll(int pageNum,int pageSize) {
//        System.out.println(pageNum);
//        System.out.println(pageSize);
//
//        // 传递 pc ,ps 获得 pageBean
//        PageBean<ExtMenu> all = menuService.findCostAllLimit(pageNum, pageSize);
//        System.out.println(all);
////        List<ExtMenu> all = menuService.findAll();
//        for (ExtMenu extMenu : all.getBeanList()) {
//            if (extMenu.getParentId() == 0) {
//                extMenu.setParent_name("");
//            } else {
//                Menu menu = menuService.findById(extMenu.getParentId());
//                extMenu.setParent_name(menu.getName());
//            }
//        }
//        return all;
//    }

    //分页+查询所有
    @ResponseBody
    @RequestMapping("/pageAll")
    public PageInfo<ExtMenu> pageAll(
            Integer pageNum,
            Integer pageSize) {
        PageInfo<ExtMenu> menuPageInfo = menuService.queryPage(pageNum, pageSize);
        for (ExtMenu extMenu : menuPageInfo.getList()) {
            if (extMenu.getParentId() == 0) {
                extMenu.setParent_name("");
            } else {
                Menu menu = menuService.findById(extMenu.getParentId());
                extMenu.setParent_name(menu.getName());
            }
        }
        return menuPageInfo;
    }


    @ResponseBody
    @RequestMapping("/showparent")
    public List<Menu> showParent() {
        return menuService.findParent();
    }

    @ResponseBody
    @RequestMapping("/addMenu")
    public AjaxResult addMenu(ExtMenu extMenu){
        System.out.println(extMenu);

        return null;
    }
}
