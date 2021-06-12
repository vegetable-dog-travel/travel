package com.igeek.travel.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.dao.OrdersDao;
import com.igeek.travel.entity.Orders;
import com.igeek.travel.vo.PageVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/9 11:42
 */
public class OrderService {

    private OrdersDao dao = new OrdersDao();

    //提交订单
    public boolean submitOrders(Orders orders){
        try {
            //开启事务  不再自动提交事务
            DataSourceUtils.startTransaction();

            //保持事务的一致性
            dao.insertOrders(orders);

            //int i = 10/0;

            dao.insertOrderItem(orders);

            return true;
        } catch (Exception e) {
            //事务回滚
            try {
                DataSourceUtils.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            //关闭资源
            //提交事务
            try {
                DataSourceUtils.commitAndRelease();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //确认订单时，更新订单中的收货人信息
    public boolean updateUserOrders(Orders orders){
        try {
            return dao.updateUserOrders(orders)>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //更新订单状态
    public boolean updateState(String oid){
        try {
            return dao.updateState(oid)>0?true:false;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //查看订单分页信息
    public PageVO<Orders> viewOrders(String uid,String page){
        int pageNow = 1;  //默认查询第一页
        if(page!=null){
            pageNow = Integer.parseInt(page);  //按照实际传递的页码处理
        }
        try {
            //查看总记录数
            int counts = dao.selectCountsOrdersByUid(uid).intValue();

            //计算总页数
            int myPages = (int)(counts%3==0?counts/3:Math.ceil(counts/3.0));

            //计算起始值
            int begin = (pageNow - 1)*3;

            //查看记录
            List<Orders> list = dao.selectOrdersByUid(uid, begin);

            //封装PageVO
            PageVO<Orders> vo = new PageVO<>(pageNow,counts,myPages,uid,null,list);
            return vo;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    //查看指定的订单的商品及其订单明细
    public List<Map<String,Object>> findItemsAndProduct(String oid){
        try {
            return dao.selectItemsAndProduct(oid);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
