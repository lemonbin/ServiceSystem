package com.baidu.menu.controller;

import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;
import com.baidu.menu.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by dllo on 2017/12/6.
 */
@Controller
public class MenuController {
    @Resource
    private MenuService menuService;


    //分页+查询所有
    @ResponseBody
    @RequestMapping("/pageAll")
    public List<ExtMenu> pageAll() {
        List<ExtMenu> all = menuService.findAll();
        for (ExtMenu extMenu : all) {
            if (extMenu.getParent_id() ==0){
                extMenu.setParent_name("");
            }else {

                Menu menu = menuService.findById(extMenu.getParent_id());

                extMenu.setParent_name(menu.getName());
            }
        }
        return all;
    }

}
