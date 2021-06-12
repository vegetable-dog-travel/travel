package com.igeek.travel.vo;

//主页面数据显示的VO类
public class HomeVO {

    //月份
    private String month;
    //每月显示订单数
    private int num;

    public HomeVO() {
    }

    public HomeVO(String month, int num) {
        this.month = month;
        this.num = num;
    }

    /**
     * 获取
     * @return month
     */
    public String getMonth() {
        return month;
    }

    /**
     * 设置
     * @param month
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * 获取
     * @return num
     */
    public int getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(int num) {
        this.num = num;
    }

    public String toString() {
        return "HomeVO{month = " + month + ", num = " + num + "}";
    }
}
