package com.baidu.role.domain;

import com.baidu.user.domain.User;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/6.
 */
public class Role {
    private int id;
    private String name;
    private int status;
    private int sort;
    private String remark;
    private Timestamp create_time;
    private int create_id;
    private User user;
    private Timestamp update_time;
    private int update_id;

    public Role() {
    }

    public Role(int id, String name, int status, int sort, String remark, Timestamp create_time, int create_id, User user, Timestamp update_time, int update_id) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.sort = sort;
        this.remark = remark;
        this.create_time = create_time;
        this.create_id = create_id;
        this.user = user;
        this.update_time = update_time;
        this.update_id = update_id;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sort=" + sort +
                ", remark='" + remark + '\'' +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                '}';
    }

    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public int getCreate_id() {
        return create_id;
    }

    public void setCreate_id(int create_id) {
        this.create_id = create_id;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public int getUpdate_id() {
        return update_id;
    }

    public void setUpdate_id(int update_id) {
        this.update_id = update_id;
    }
}
