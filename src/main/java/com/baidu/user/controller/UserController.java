package com.baidu.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class UserController {

    @RequestMapping("/admin-add")
    public String admin_add(){
        return "admin/admin-add";
    }
}
