package com.baidu.base.domain;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/13.
 */
public class IPAddress {
    private int id;
    private String ip;
    private int count;
    private Timestamp login_time;

    public IPAddress() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timestamp getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Timestamp login_time) {
        this.login_time = login_time;
    }
}
