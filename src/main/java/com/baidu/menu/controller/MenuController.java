package com.baidu.menu.controller;

import com.baidu.base.utils.AjaxResult;
import com.baidu.menu.domain.Menu;
import com.baidu.menu.domain.ext.ExtMenu;
import com.baidu.menu.service.MenuService;
import com.baidu.user.domain.User;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public AjaxResult addMenu(Menu menu, HttpServletRequest request) {
        User user = (User) request.getServletContext().getAttribute("user");
        menu.setCreate_id(user.getId());
        menu.setIcon("&#xe616;");
        menu.setStatus(1);
        if (menu.getParentId() == 0) {
            menu.setType(1);
        } else {
            menu.setType(4);
        }
        menu.setLevel(1);
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        menu.setCreateTime(Timestamp.valueOf(dateFormat.format(now)));
        menu.setUpdate_time(Timestamp.valueOf(dateFormat.format(now)));
        List<ExtMenu> all = menuService.findAll();
        menu.setSort(all.size() + 1);
        AjaxResult ajaxResult = new AjaxResult();
        int insert = menuService.insert(menu);
        if (insert > 0) {
            ajaxResult.setMessage("添加成功");

        } else {
            ajaxResult.setMessage("添加失败");
        }
        return ajaxResult;
    }

//    @ResponseBody
//    @RequestMapping("/admin-role-edit")
//    public Menu admin_role_edit(Integer id) {
//
//        System.out.println(menuService.findById(id));
//        return menuService.findById(id);
//    }

    @RequestMapping("/admin-role-edit")
    public String admin_role_edit(int id) {
        return "admin/admin-role-add?id=" + id + "";
    }
}
