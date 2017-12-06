package com.baidu.menu.controller;

import com.baidu.menu.domain.Menu;
import com.baidu.menu.service.MenuService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


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
    public PageInfo<Menu> pageAll(Integer info,
                                  Integer pageNum,
                                  Integer pageSize,
                                  HttpSession session){

        System.out.println("info+++++++"+info);
        System.out.println("pageNum+++"+pageNum);
        System.out.println("pageSize"+pageSize);
//        System.out.println("info2******"+info2);
        PageInfo<Menu> costPageInfo = null;
        //这是判断我点击分页的1,2,3,4,5,6--之后的操作数据(升序,降序)
        if (info != 6) {
            session.setAttribute("info",info);
            costPageInfo = menuService.queryPage(info,pageNum,pageSize);

        }else {
            Integer info1 = (Integer) session.getAttribute("info");
            costPageInfo = menuService.queryPage(info1, pageNum, pageSize);
        }
        System.out.println("costPageInfo分页"+ costPageInfo);
        return costPageInfo;
    }

}
