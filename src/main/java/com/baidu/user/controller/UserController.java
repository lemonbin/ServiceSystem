package com.baidu.user.controller;

import com.baidu.base.utils.AjaxResult;
import com.baidu.user.domain.User;
import com.baidu.user.domain.ext.ExtUser;
import com.baidu.user.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    //111
    @Resource
    private UserService userService;

    @RequestMapping("/admin-add")
    public String admin_add() {
        return "admin/admin-add";
    }
    @RequestMapping("/admin-list")

    public String admin_list() {
        return "admin/admin-list";
    }

    @ResponseBody
    @RequestMapping("/findAllUser")
    public List<User> getAllUser() {
        List<User> users = userService.getAllUser();
        return users;
    }

    /**
     * 分页 + 查询所有
     */
    @ResponseBody
    @RequestMapping("/pageAllUser")
    public PageInfo<User> pageAllUser(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, HttpSession session) {
        PageInfo<User> pageInfo = userService.queryPage(pageNum, pageSize);
        return pageInfo;
    }

    /**
     * 分页 + 高级查询
     */
    @ResponseBody
    @RequestMapping("/findPageAll")
    public PageInfo<User> findPageAll(ExtUser extUser, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, HttpSession session) {
        PageInfo<User> pageInfo = userService.fuzzyQueryPage(extUser,pageNum, pageSize);
        return pageInfo;
    }

    /**
     * 添加用户
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public void addUser(User user, HttpServletRequest request) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreate_time(Timestamp.valueOf(dateFormat.format(now)));
        User user1 = (User) request.getServletContext().getAttribute("user");
        user.setCreate_id(user1.getId());
        userService.addUser(user);
    }

    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping("/deleteUser")
    public AjaxResult deleteUser(Integer id) {
        AjaxResult ajaxResult = new AjaxResult();
        userService.delById(id);
        return ajaxResult;
    }

    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/deleteUsers")
    public boolean del(@RequestParam("del") String del) {
        return userService.datadel(del);
    }
}
