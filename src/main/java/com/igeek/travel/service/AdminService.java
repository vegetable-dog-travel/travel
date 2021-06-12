package com.igeek.travel.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.dao.AdminDao;
import com.igeek.travel.entity.Admin;
import com.igeek.travel.entity.Category;
import com.igeek.travel.entity.Product;
import com.igeek.travel.vo.HomeVO;
import com.igeek.travel.vo.PageVO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AdminService {

    private AdminDao dao = new AdminDao();

    //登录
    public Admin login(String name , String pwd){
        Admin admin = null;
        try {
            admin = dao.selectOne(name, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }

    //显示本年度每月订单数
    public List<HomeVO> showIndex(){
        try {
            return dao.selectOrdersNumByMonth();
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

    //分页查询
    public PageVO findAll(String query , int pageNow){
        PageVO vo = new PageVO();

        //给当前页传值
        vo.setPageNow(pageNow);

        //查询总记录数
        int myCounts = 0;
        try {
            myCounts = dao.selectCounts(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //计算总页数
        int myPages = (int)(myCounts%5==0 ? myCounts/5 : (myCounts/5)+1);
        vo.setMyPages(myPages);

        //当页的数据记录
        int begin =  (pageNow - 1)*5;
        List<? extends Object> list = null;
        try {
            list = dao.selectAll(query, begin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        vo.setList(list);

        //返回分页的辅助类对象
        return vo;
    }

    //通过商品编号查询商品信息
    public List<Map<String,Object>> findOneById(String pid){
        try {
            return dao.selectOneById(pid);
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


    //查询所有商品分类
    public List<Category> findAllCategory(){
        try {
            return dao.selectAllCategory();
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

    //更新商品信息
    public boolean update(Product product) {
        try {
            return dao.update(product)>0?true:false;
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

    //通过类别编号查询类别信息
    public Category findOneCategoryByCid(String cid){
        try {
            return dao.selectOneCategoryById(cid);
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
