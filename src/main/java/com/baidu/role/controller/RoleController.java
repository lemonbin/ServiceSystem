package com.baidu.role.controller;

import com.baidu.base.utils.AjaxResult;
import com.baidu.role.domain.Role;
import com.baidu.role.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
@Controller
public class RoleController {

    @Resource
    private RoleService roleService;

    /**
     * 跳转
     */
    @RequestMapping("/admin-permission-add")
    public String admin_permission_add() {
        return "admin/admin-permission-add";
    }

    /**
     * 查询所有
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAllRole")
    public List<Role> getAllRole() {
        List<Role> roles = roleService.getAllRole();
        return roles;
    }

    /**
     * 分页 +高级查询
     */
    @ResponseBody
    @RequestMapping("/rolePageAll")
    public PageInfo<Role> pageAll(Role role, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, HttpSession session) {
        PageInfo<Role> pageInfo = null;

        if (!role.getName().equals("5")) {
            session.setAttribute("role", role);
            pageInfo = roleService.fuzzyQueryPage(role, pageNum, pageSize);
        } else {
            Role role1 = (Role) session.getAttribute("role");
            pageInfo = roleService.fuzzyQueryPage(role1, pageNum, pageSize);
        }
        return pageInfo;
    }

    /**
     * 分页+普通查询 findpageAll
     */
    @ResponseBody
    @RequestMapping("/findpageAll")
    public PageInfo<Role> pageAll(@RequestParam("info") Integer info, @RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize, HttpSession session) {
        PageInfo<Role> pageInfo = null;
        if (info != 6) {
            pageInfo = roleService.queryPage(info, pageNum, pageSize);
            session.setAttribute("info", info);

        } else {
            Integer info1 = (Integer) session.getAttribute("info");
            pageInfo = roleService.queryPage(info1, pageNum, pageSize);
        }

        return pageInfo;
    }


    /**
     * 角色添加
     */

    @ResponseBody
    @RequestMapping("admin/admin-role-save")
    public AjaxResult admin_role_save(Role role) {
        AjaxResult result = new AjaxResult();
        role.setCreate_time(new Timestamp(System.currentTimeMillis()));
        role.setUpdate_time(new Timestamp(System.currentTimeMillis()));
        role.setCreate_id(1);
        int count = roleService.save(role);
        result.setErrorCode(count);
        return result;
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("admin/deleteTheRole")
    public boolean deleteTheRole(@RequestParam("id") Integer id) {
        return roleService.deleteTheRole(id);
    }


    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("admin/datadel")
    public boolean del(@RequestParam("del") String del) {
        return roleService.datadel(del);
    }

    /**
     * 回显
     */
    @RequestMapping("/admin-permission-edit")
    public String admin_role_edit() {
        return "admin/admin-permission-add";
    }

    /**
     * 编辑
     */
    @ResponseBody
    @RequestMapping("/editRole")
    public Role editRole(Integer id){
        return roleService.findById(id);
    }

}
