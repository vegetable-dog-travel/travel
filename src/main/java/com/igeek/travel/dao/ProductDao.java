package com.igeek.travel.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.entity.Product;

import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/7 9:19
 */
public class ProductDao extends BasicDao<Product> implements IDao<Product> {

    //查询热门的9条商品信息的数据
    public List<Product> selectAllHot() throws Exception {
        String sql = "select pid , pname , pimage , shop_price , cid  from product where is_hot=1 limit 0,9";
        List<Product> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Product.class);
        return list;
    }

    //查询最新的9条商品信息的数据
    public List<Product> selectAllNew() throws Exception {
        String sql = "select pid , pname , pimage , shop_price , cid from product order by pdate desc limit 0,9";
        List<Product> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Product.class);
        return list;
    }

    //查询商品列表
    @Override
    public List<Product> selectAll(Object... params) throws Exception {
        Object cid = params[0];
        String sql = "";
        if(cid==null || cid.equals("")){
            sql ="select pid , pname , pimage , shop_price , cid " +
                    "from product " +
                    "where pname like concat('%',?,'%') limit ?,12";
            List<Product> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Product.class,
                    params[1],params[2]);
            return list;
        }else if(cid!=null || !cid.equals("")){
            sql ="select pid , pname , pimage , shop_price , cid " +
                    "from product " +
                    "where cid = ? and pname like concat('%',?,'%') limit ?,12";
            List<Product> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Product.class, params);
            return list;
        }
       return null;
    }

    //查询商品列表的总记录数
    @Override
    public Long selectValue(Object... params) throws Exception {
        //第一个参数必须是商品类别编号
        Object cid = params[0];
        String sql = "";
        if(cid==null || cid.equals("")){
            sql ="select count(*) " +
                    "from product " +
                    "where pname like concat('%',?,'%')";
            Long value = (Long)this.getSingleValue(DataSourceUtils.getConnection(), sql, params[1]);
            return value;
        }else if(cid!=null || !cid.equals("")){
            sql = "select count(*) " +
                    "from product " +
                    "where cid = ? and pname like concat('%',?,'%')";
            Long value = (Long)this.getSingleValue(DataSourceUtils.getConnection(), sql, params);
            return value;
        }
        return 0L;
    }

    @Override
    public Product selectOne(Object... params) throws Exception {
        String sql = "select pid , pname , pimage , shop_price , cid , market_price from product where pid = ?";
        Product product = this.getBean(DataSourceUtils.getConnection(), sql, Product.class, params);
        return product;
    }

    @Override
    public int update(Object... params) throws Exception {
        return 0;
    }

    @Override
    public int delete(String id) throws Exception {
        return 0;
    }

    @Override
    public int insert(Product product) throws Exception {
        return 0;
    }
}
