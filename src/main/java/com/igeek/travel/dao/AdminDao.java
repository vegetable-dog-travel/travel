package com.igeek.travel.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.entity.*;
import com.igeek.travel.vo.HomeVO;
import com.igeek.travel.entity.Admin;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdminDao extends BasicDao{

    //通过姓名和密码查询信息
    public Admin selectOne(String name, String pwd) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "select * from t_admin where adminName = ? and adminPwd = ?";
        Admin admin = runner.query(DataSourceUtils.getConnection(), sql, new BeanHandler<>(Admin.class), name , pwd);
        return admin;
    }

    //显示本年度每月订单数
    public List<HomeVO> selectOrdersNumByMonth() throws SQLException {
        String sql = "select month(ordertime) month , count(*) num from orders where year(now()) = year(ordertime) group by month(ordertime) order by month";
        List<HomeVO> list = this.getBeanList(DataSourceUtils.getConnection() , sql , HomeVO.class );
        return list;
    }

    //查询指定表的总记录数
    public int selectCounts(String query) throws SQLException {
        QueryRunner runner = new QueryRunner();
        String sql = "select count(*) from product where pname like concat('%',?,'%') and pflag=0 ";
        int value = ((Long)this.getSingleValue(DataSourceUtils.getConnection(), sql, query)).intValue();
        return value;
    }

    //查询指定表中的数据
    public List<? extends Object> selectAll(String query,int begin) throws SQLException {
        String sql = "select * from product " +
                "where pname like concat('%',?,'%') and pflag=0 " +
                "order by pid+0 limit ?,5";
        List<Product> productList = this.getBeanList(DataSourceUtils.getConnection() , sql , Product.class , query , begin);
        return productList;
    }

    //通过商品编号查询商品信息
    public List<Map<String,Object>> selectOneById(String pid) throws SQLException {
        String sql = "select * from product p , category c where p.cid = c.cid and p.pid = ?";
        List<Map<String,Object>> mapList = this.getMapList(DataSourceUtils.getConnection(), sql, pid);
        return mapList;
    }

    //查询所有的商品类别
    public List<Category> selectAllCategory() throws SQLException {
        String sql = "select * from category";
        List<Category> list = this.getBeanList(DataSourceUtils.getConnection(),sql,Category.class);
        return list;
    }

    //更新商品
    public int update(Product product) throws SQLException {
        String sql = "update product set pname=? , market_price=? , shop_price=? " +
                ",pimage=?,pdate=?,pdesc=?,cid=? where pid=?";
        int i = this.updateInfo(DataSourceUtils.getConnection(),sql,
                product.getPname() , product.getMarket_price() , product.getShop_price(),
                product.getPimage() , product.getPdate() , product.getPdesc(),
                product.getCategory().getCid(),product.getPid());
        return i;
    }


    //通过类别编号，查询类别信息
    public Category selectOneCategoryById(String cid) throws SQLException {
        String sql = "select * from category where cid = ?";
        Category category = (Category)this.getBean(DataSourceUtils.getConnection(),sql,Category.class,cid);
        return category;
    }
}
