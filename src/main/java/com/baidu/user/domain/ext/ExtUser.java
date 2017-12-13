package com.baidu.user.domain.ext;

import com.baidu.user.domain.User;

/**
 * Created by dllo on 17/12/13.
 */
public class ExtUser extends User{
    private String datemin;
    private String datemax;

    public ExtUser() {
    }

    public String getDatemin() {
        return datemin;
    }

    public void setDatemin(String datemin) {
        this.datemin = datemin;
    }

    public String getDatemax() {
        return datemax;
    }

    public void setDatemax(String datemax) {
        this.datemax = datemax;
    }
}
