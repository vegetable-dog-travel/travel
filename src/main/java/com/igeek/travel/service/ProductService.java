package com.igeek.travel.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.dao.ProductDao;
import com.igeek.travel.entity.Product;
import com.igeek.travel.vo.PageVO;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @Description 商品的业务逻辑层
 * @Author chenmin
 * @Date 2021/6/7 9:24
 */
public class ProductService {

    private ProductDao dao = new ProductDao();

    //查询热门的9条商品信息的数据
    public List<Product> findHotProducts(){
        try {
            return dao.selectAllHot();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    //查询最新的9条商品信息的数据
    public List<Product> findNewProducts(){
        try {
            return dao.selectAllNew();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    //根据商品类别和商品名称模糊查询，分页查询
    public PageVO<Product> findProducts(String cid,String pname,Integer pageNow){
        try {
            //查询总记录数
            int myCounts = dao.selectValue(cid,pname).intValue();

            //计算总页数
            int myPages = (int)(myCounts%12==0?myCounts/12:Math.ceil(myCounts/12.0));

            //计算每页起始值
            int begin = (pageNow-1)*12;

            //查询记录列表
            List<Product> list = dao.selectAll(cid,pname,begin);

            //封装PageVO对象
            PageVO<Product> vo = new PageVO<>(pageNow,myCounts,myPages,cid,pname,list);
            return vo;
        } catch (Exception e) {
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

    //通过商品编号查询商品信息
    public Product findProductByPid(String pid){
        try {
            return dao.selectOne(pid);
        } catch (Exception e) {
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
