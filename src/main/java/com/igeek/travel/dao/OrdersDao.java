package com.igeek.travel.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.entity.OrderItem;
import com.igeek.travel.entity.Orders;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Description 订单及订单明细的数据交互层
 * @Author chenmin
 * @Date 2021/6/9 11:43
 */
public class OrdersDao extends BasicDao<Orders> {

    //插入订单Orders信息
    public int insertOrders(Orders orders) throws SQLException {
        String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
        int i = this.updateInfo(DataSourceUtils.getConnection(),sql,
                orders.getOid() , orders.getOrdertime(),
                orders.getTotal() , orders.getState(),
                orders.getAddress() , orders.getName() , orders.getTelephone(),
                orders.getUser().getUid());
        return i;
    }

    //插入订单明细OrderItem信息
    public void insertOrderItem(Orders orders) throws SQLException {
        String sql = "insert into orderitem values(UUID_SHORT(),?,?,?,?)";
        List<OrderItem> list = orders.getList();
        for (OrderItem orderItem : list) {
            this.updateInfo(DataSourceUtils.getConnection(),sql,
                    orderItem.getCount() , orderItem.getSubtotal(),
                    orderItem.getProduct().getPid(),
                    orderItem.getOrders().getOid());
        }
    }

    //更新订单中的收货人信息
    public int updateUserOrders(Orders orders) throws SQLException {
        String sql = "update orders set name=? , address=? , telephone=? where oid=?";
        int i = this.updateInfo(DataSourceUtils.getConnection(),sql,
                orders.getName() , orders.getAddress(),
                orders.getTelephone() , orders.getOid());
        return i;
    }

    //更新订单中的状态
    public int updateState(String oid) throws SQLException {
        String sql = "update orders set state = 1 where oid = ?";
        int i = this.updateInfo(DataSourceUtils.getConnection(), sql, oid);
        return i;
    }


    //查看当前用户的订单信息
    public List<Orders> selectOrdersByUid(String uid,int begin) throws SQLException {
        String sql = "select * from orders where uid = ? order by ordertime desc limit ?,3";
        List<Orders> ordersList = this.getBeanList(DataSourceUtils.getConnection(), sql, Orders.class, uid, begin);
        return ordersList;
    }

    //查看当前用户的订单总记录数
    public Long selectCountsOrdersByUid(String uid) throws SQLException {
        String sql = "select count(*) from orders where uid = ?";
        Long count = (Long)this.getSingleValue(DataSourceUtils.getConnection(), sql, uid);
        return count;
    }

    //查看指定的订单的商品及其订单明细
    public List<Map<String,Object>> selectItemsAndProduct(String oid) throws SQLException {
        String sql = "select i.* ,  p.pimage , p.pname , p.shop_price " +
                "from orderitem i , product p where i.pid = p.pid and oid = ?";
        List<Map<String, Object>> mapList = this.getMapList(DataSourceUtils.getConnection(), sql, oid);
        return mapList;
    }
}
