package com.igeek.travel.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 通过DBUtils定义了一套CRUD具体实现模板
 * @param <T>
 */
public class BasicDao<T> {

    private QueryRunner runner = new QueryRunner();

    //查询单行单列数据
    public Object getSingleValue(Connection conn,String sql,Object...params) throws SQLException {
        Object value = runner.query(conn, sql, new ScalarHandler<>(), params);
        return value;
    }

    //查询单个对象
    public T getBean(Connection conn,String sql,Class<T> clazz , Object...params) throws SQLException {
        T t = runner.query(conn, sql, new BeanHandler<>(clazz), params);
        return t;
    }

    //查询多个对象
    public List<T> getBeanList(Connection conn, String sql, Class<T> clazz , Object...params) throws SQLException {
        List<T> list = runner.query(conn, sql, new BeanListHandler<>(clazz), params);
        return list;
    }

    //增删改
    public int updateInfo(Connection conn,String sql,Object...params) throws SQLException {
        int i = runner.update(conn, sql, params);
        return i;
    }

    //查询   Map<表中字段的名称, 表中字段对应的值>
    public List<Map<String, Object>> getMapList(Connection conn,String sql,Object...params) throws SQLException {
        List<Map<String, Object>> list = runner.query(conn, sql, new MapListHandler(), params);
        return list;
    }
}
