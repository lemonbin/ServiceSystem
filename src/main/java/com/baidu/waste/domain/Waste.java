package com.baidu.waste.domain;

import java.sql.Timestamp;

/**
 * Created by dllo on 17/12/14.
 */
public class Waste {
    private int id;
    private String wastetype;
    private String collector;
    private Timestamp coltime;
    private int colstatus;
    private int classstatus;
    private int orderstatus;

    public Waste() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWastetype() {
        return wastetype;
    }

    public void setWastetype(String wastetype) {
        this.wastetype = wastetype;
    }

    public String getCollector() {
        return collector;
    }

    public void setCollector(String collector) {
        this.collector = collector;
    }

    public Timestamp getColtime() {
        return coltime;
    }

    public void setColtime(Timestamp coltime) {
        this.coltime = coltime;
    }

    public int getColstatus() {
        return colstatus;
    }

    public void setColstatus(int colstatus) {
        this.colstatus = colstatus;
    }

    public int getClassstatus() {
        return classstatus;
    }

    public void setClassstatus(int classstatus) {
        this.classstatus = classstatus;
    }

    public int getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }
}
