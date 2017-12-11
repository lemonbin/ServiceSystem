package com.baidu.user.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by dllo on 17/12/6.
 */
public class UserTest {

    public static void main(String[] args) {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式


        String hehe = dateFormat.format( now );
        System.out.println(hehe);
    }
}
