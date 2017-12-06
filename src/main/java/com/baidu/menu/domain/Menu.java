package com.baidu.menu.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by dllo on 2017/12/6.
 */
public class Menu implements Serializable {

    private int id;
    private int parent_id;
    private String icon;
    private String name;
    private String urlkey;
    private int status;
    private int type;
    private int sort;
    private int level;
    private Timestamp create_time;
    private int create_id;
    private Timestamp update_time;
    private int update_id;

    public Menu() {
    }

    public Menu(int id, int parent_id, String icon, String name, String urlkey, int status, int type, int sort, int level, Timestamp create_time, int create_id, Timestamp update_time, int update_id) {
        this.id = id;
        this.parent_id = parent_id;
        this.icon = icon;
        this.name = name;
        this.urlkey = urlkey;
        this.status = status;
        this.type = type;
        this.sort = sort;
        this.level = level;
        this.create_time = create_time;
        this.create_id = create_id;
        this.update_time = update_time;
        this.update_id = update_id;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", urlkey='" + urlkey + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", sort=" + sort +
                ", level=" + level +
                ", create_time=" + create_time +
                ", create_id=" + create_id +
                ", update_time=" + update_time +
                ", update_id=" + update_id +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
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
