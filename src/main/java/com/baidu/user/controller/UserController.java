package com.baidu.user.controller;

import com.baidu.user.domain.User;
import com.baidu.user.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class UserController {
    //111
    @Resource
    private UserService userService;

    @RequestMapping("/admin-add")
    public String admin_add() {
        return "admin/admin-add";
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
        System.out.println(pageInfo);
        return pageInfo;
    }
}
