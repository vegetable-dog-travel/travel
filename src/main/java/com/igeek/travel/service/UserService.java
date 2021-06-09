package com.igeek.travel.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.travel.dao.IDao;
import com.igeek.travel.dao.UserDao;
import com.igeek.travel.entity.User;

import java.sql.SQLException;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2021/6/5 14:07
 */
public class UserService {

    private IDao<User> dao = new UserDao();

    //注册
    public boolean register(User user){
        try {
            return dao.insert(user)>0 ?true:false;
        } catch (Exception e) {
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


    //激活账户状态
    public boolean active(String code){
        try {
            int i = dao.update(code);
            return i>0?true:false;
        } catch (Exception e) {
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

    //校验名称是否存在
    public boolean validate(String name){
        Long value = 0L;
        try {
            //value  代表按照姓名查询的记录数
            value = (Long)dao.selectValue(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //若记录数>0，则查到，true，代表不可用
        //若记录数=0，则未查到，false，代表可用
        return value>0?true:false;
    }
}
