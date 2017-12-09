package com.baidu.base.utils;

import java.util.List;

/**
 * 第 M/N 页 首页 上一页 [1][2] ....[10] 下一页 尾页 []GO!
 * 分页的 bean
 * 1. 当前页码 pageCode , pc
 * 2. 总页数: totalPage, tp 总记录数/每页记录数
 * 3. 总记录数: totalRecord, tr dao: 查询 select count(*)
 * 4. 每页记录数: pageSize ps
 * 5. 当前页的数据: beanList bl
 * 6. url
 */
public class PageBean<T> {
    private int pageCode; //当前页码
    //    private int totalPage; //总页码数
    private int totalRecord; //总记录数
    private int pageSize; //每页记录数
    private List<T> beanList; //当前页记录
    private String url; //url后面的条件

    private int start;

    @Override
    public String toString() {
        return "PageBean{" +
                "pageCode=" + pageCode +
                ", totalRecord=" + totalRecord +
                ", pageSize=" + pageSize +
                ", beanList=" + beanList +
                ", url='" + url + '\'' +
                ", start=" + start +
                '}';
    }

    public int getPageCode() {
        return pageCode;
    }

    public void setPageCode(int pageCode) {
        this.pageCode = pageCode;
    }

    /* 计算总页数 */
    public int getTotalPage() {
        //总记录数/每页记录数
        if (totalRecord % pageSize == 0) {
            return totalRecord / pageSize;
        } else {
            return (totalRecord / pageSize) + 1;
        }
    }

//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
