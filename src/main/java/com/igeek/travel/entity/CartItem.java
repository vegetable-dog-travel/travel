package com.igeek.travel.entity;

/**
 * @version 1.0
 * @Description 购物车明细
 * @Author chenmin
 * @Date 2021/6/8 10:35
 */
public class CartItem {

    //一对一关联商品信息
    private Product product;

    //购买数量
    private Integer buyNum;

    //小计
    private double subTotal;


    public CartItem() {
    }

    public CartItem(Product product, Integer buyNum, double subTotal) {
        this.product = product;
        this.buyNum = buyNum;
        this.subTotal = subTotal;
    }

    /**
     * 获取
     * @return product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * 设置
     * @param product
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * 获取
     * @return buyNum
     */
    public Integer getBuyNum() {
        return buyNum;
    }

    /**
     * 设置
     * @param buyNum
     */
    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    /**
     * 获取
     * @return subTotal
     */
    public double getSubTotal() {
        return subTotal;
    }

    /**
     * 设置
     * @param subTotal
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public String toString() {
        return "CartItem{product = " + product + ", buyNum = " + buyNum + ", subTotal = " + subTotal + "}";
    }
}
