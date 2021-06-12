package com.igeek.travel.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.entity.Category;

import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/7 10:13
 */
public class CategoryDao extends BasicDao<Category> implements IDao<Category>{

    @Override
    public Category selectOne(Object... params) throws Exception {
        return null;
    }

    //查询所有商品类别
    @Override
    public List<Category> selectAll(Object... params) throws Exception {
        String sql = "select * from category";
        List<Category> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Category.class, params);
        return list;
    }

    @Override
    public String selectValue(Object... params) throws Exception {
        String sql = "select cname from category where cid=?";
        String cname = this.getSingleValue(DataSourceUtils.getConnection(), sql, params).toString();
        return cname;
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
    public int insert(Category categoryDao) throws Exception {
        return 0;
    }
}
