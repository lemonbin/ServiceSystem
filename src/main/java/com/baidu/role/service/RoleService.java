package com.baidu.role.service;

import com.baidu.role.domain.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface RoleService {
    List<Role> getAllRole();

    PageInfo<Role> queryPage(Integer info, Integer pageNum, Integer pageSize);

    boolean deleteTheRole(Integer id);

    PageInfo<Role> GJqueryPage(Role role, Integer pageNum, Integer pageSize);

    boolean datadel(String del);


    List<Role> findAllRole();

    int save(Role role);
}
