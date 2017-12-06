package com.baidu.base.utils;

/**
 * Created by dllo on 17/12/6.
 */
public class AjaxResult {
    private String message;
    private boolean status;
    private int errorCode;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
