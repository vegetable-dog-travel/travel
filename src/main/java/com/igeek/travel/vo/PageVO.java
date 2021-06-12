package com.igeek.travel.vo;

import java.util.List;

/**
 * @version 1.0
 * @Description 分页辅助类
 * @Author chenmin
 * @Date 2021/6/7 11:11
 */
public class PageVO<T> {

    private Integer pageNow;
    private Integer myCounts;
    private Integer myPages;
    private String query1;
    private String query2;
    private List<T> list;

    public PageVO() {
    }

    public PageVO(Integer pageNow, Integer myCounts, Integer myPages, String query1, String query2, List<T> list) {
        this.pageNow = pageNow;
        this.myCounts = myCounts;
        this.myPages = myPages;
        this.query1 = query1;
        this.query2 = query2;
        this.list = list;
    }

    /**
     * 获取
     * @return pageNow
     */
    public Integer getPageNow() {
        return pageNow;
    }

    /**
     * 设置
     * @param pageNow
     */
    public void setPageNow(Integer pageNow) {
        this.pageNow = pageNow;
    }

    /**
     * 获取
     * @return myCounts
     */
    public Integer getMyCounts() {
        return myCounts;
    }

    /**
     * 设置
     * @param myCounts
     */
    public void setMyCounts(Integer myCounts) {
        this.myCounts = myCounts;
    }

    /**
     * 获取
     * @return myPages
     */
    public Integer getMyPages() {
        return myPages;
    }

    /**
     * 设置
     * @param myPages
     */
    public void setMyPages(Integer myPages) {
        this.myPages = myPages;
    }

    /**
     * 获取
     * @return query1
     */
    public String getQuery1() {
        return query1;
    }

    /**
     * 设置
     * @param query1
     */
    public void setQuery1(String query1) {
        this.query1 = query1;
    }

    /**
     * 获取
     * @return query2
     */
    public String getQuery2() {
        return query2;
    }

    /**
     * 设置
     * @param query2
     */
    public void setQuery2(String query2) {
        this.query2 = query2;
    }

    /**
     * 获取
     * @return list
     */
    public List<T> getList() {
        return list;
    }

    /**
     * 设置
     * @param list
     */
    public void setList(List<T> list) {
        this.list = list;
    }

    public String toString() {
        return "PageVO{pageNow = " + pageNow + ", myCounts = " + myCounts + ", myPages = " + myPages + ", query1 = " + query1 + ", query2 = " + query2 + ", list = " + list + "}";
    }
}
