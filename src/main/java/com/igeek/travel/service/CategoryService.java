package com.igeek.travel.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.dao.CategoryDao;
import com.igeek.travel.entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/7 10:17
 */
public class CategoryService {

    private CategoryDao dao = new CategoryDao();

    //查询所有的商品类别
    public List<Category> findAllCategories(){
        try {
            return dao.selectAll();
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

    //通过cid获取cname的方法
    public String findCname(String cid){
        try {
            return dao.selectValue(cid);
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
