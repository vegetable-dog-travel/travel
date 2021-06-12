package com.igeek.travel.entity;

/**
 * @version 1.0
 * @Description 订单明细
 * @Author chenmin
 * @Date 2021/6/9 10:00
 */
public class OrderItem {
    //明细编号
    private String itemid;
    //购买数量
    private int count;
    //小计
    private double subtotal;

    //商品信息  一条订单明细只能有一个商品
    private Product product;

    //订单信息  一条订单明细只能从属于一个订单
    private Orders orders;


    public OrderItem() {
    }

    public OrderItem(String itemid, int count, double subtotal, Product product, Orders orders) {
        this.itemid = itemid;
        this.count = count;
        this.subtotal = subtotal;
        this.product = product;
        this.orders = orders;
    }

    /**
     * 获取
     * @return itemid
     */
    public String getItemid() {
        return itemid;
    }

    /**
     * 设置
     * @param itemid
     */
    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    /**
     * 获取
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 获取
     * @return subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * 设置
     * @param subtotal
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
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
     * @return orders
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     * 设置
     * @param orders
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

}
