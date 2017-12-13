package com.baidu.base.domain;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/13.
 */
public class IPAddress {
    private int id;
    private String ip;
    private int count;
    private Timestamp loginTime;

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

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }
}
