package com.igeek.travel.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/5 14:05
 */
public class UserDao extends BasicDao<User> implements IDao<User> {
    @Override
    public User selectOne(Object... params) {
        return null;
    }

    @Override
    public List<User> selectAll(Object... params) {
        return null;
    }

    @Override
    public Object selectValue(Object... params) throws SQLException {
        String sql = "select count(*) from tab_user where username =?";
        Long value = (Long) this.getSingleValue(DataSourceUtils.getConnection(), sql, params);
        return value;
    }

    @Override
    public int update(Object... params) throws SQLException {
        String sql = "update tab_user set state = 1 where code = ?";
        int i = this.updateInfo(DataSourceUtils.getConnection(), sql, params);
        return i;
    }

    @Override
    public int delete(String id) {
        return 0;
    }

    //插入
    @Override
    public int insert(User user) throws SQLException {
        String sql = "insert into tab_user values(?,?,?,?,?,?,?,?,0,?)";
        int i = this.updateInfo(DataSourceUtils.getConnection(), sql,
                user.getUid(), user.getUsername(), user.getPassword(),
                user.getName(), user.getBirthday(), user.getSex(),
                user.getTelephone(), user.getEmail(), user.getCode());
        return i;
    }
}
