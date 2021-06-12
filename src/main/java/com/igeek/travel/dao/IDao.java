package com.igeek.travel.dao;

import java.util.List;

/**
 *  基础的CRUD规范
 */
public interface IDao<T> {

    T selectOne(Object... params) throws Exception;

    List<T> selectAll(Object... params) throws Exception;

    Object selectValue(Object... params) throws Exception;

    int update(Object... params) throws Exception;

    int delete(String id) throws Exception;

    int insert(T t) throws Exception;
}
