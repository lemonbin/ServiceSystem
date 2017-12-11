package com.baidu.role.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class RoleController {

    @RequestMapping("/admin-permission-add")
    public String admin_permission_add(){
        return "admin/admin-permission-add";
    }
}
