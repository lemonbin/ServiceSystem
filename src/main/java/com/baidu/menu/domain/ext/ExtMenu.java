package com.baidu.menu.domain.ext;

import com.baidu.menu.domain.Menu;

/**
 * Created by dllo on 2017/12/6.
 */
public class ExtMenu extends Menu{
    private String username;
    private String parent_name;

    @Override
    public String toString() {
        return "ExtMenu{" +
                "username='" + username + '\'' +
                ", parent_name='" + parent_name + '\'' +
                "} " + super.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }
}
