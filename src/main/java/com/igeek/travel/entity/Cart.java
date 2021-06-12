package com.igeek.travel.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 1.0
 * @Description 购物车
 * @Author chenmin
 * @Date 2021/6/8 10:35
 */
public class Cart {

    //一对多  购物车明细   Map<商品的pid , 购物车项>
    private Map<String,CartItem> map = new HashMap<>();

    //商品总金额
    private double total;


    public Cart() {
    }

    public Cart(Map<String, CartItem> map, double total) {
        this.map = map;
        this.total = total;
    }

    /**
     * 获取
     * @return map
     */
    public Map<String, CartItem> getMap() {
        return map;
    }

    /**
     * 设置
     * @param map
     */
    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    /**
     * 获取
     * @return total
     */
    public double getTotal() {
        return total;
    }

    /**
     * 设置
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    public String toString() {
        return "Cart{map = " + map + ", total = " + total + "}";
    }
}
