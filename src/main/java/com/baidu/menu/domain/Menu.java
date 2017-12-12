package com.baidu.menu.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by dllo on 2017/12/6.
 */
public class Menu implements Serializable {

    private int id;
    private int parentId;
    private String icon;
    private String name;
    private String urlkey;
    private String url;
    private int status;
    private int type;
    private int sort;
    private int level;
    private Timestamp createTime;
    private int createId;
    private Timestamp updateTime;
    private int updateId;

    public Menu() {
    }

    public Menu(int id, int parentId, String icon, String name, String urlkey, String url, int status, int type, int sort, int level, Timestamp createTime, int createId, Timestamp updateTime, int updateId) {
        this.id = id;
        this.parentId = parentId;
        this.icon = icon;
        this.name = name;
        this.urlkey = urlkey;
        this.url = url;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.level = level;
        this.createTime = createTime;
        this.createId = createId;
        this.updateTime = updateTime;
        this.updateId = updateId;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", urlkey='" + urlkey + '\'' +
                ", url='" + url + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", sort=" + sort +
                ", level=" + level +
                ", createTime=" + createTime +
                ", createId=" + createId +
                ", updateTime=" + updateTime +
                ", updateId=" + updateId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlkey() {
        return urlkey;
    }

    public void setUrlkey(String urlkey) {
        this.urlkey = urlkey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getCreateId() {
        return createId;
    }

    public void setCreateId(int createId) {
        this.createId = createId;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }
}
