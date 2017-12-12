package com.baidu.role.mapper;

import com.baidu.role.domain.Role;

import java.util.List;

/**
 * Created by dllo on 17/12/6.
 */
public interface RoleMapper {
    List<Role> getAllRole();
    List<Role> findAll();

    int deleteByRoleId(Integer id);

    int deleteForU_RoleId(Integer id);

    List<Role> findAllGJ(Role role);

    Role findRoleById(int roleid);

    int findMaxSort();

    int save(Role role);
}
