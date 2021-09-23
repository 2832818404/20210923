package com.bookstore.dao;

import com.bookstore.beans.User;

import java.sql.Connection;

/**
 * @author hongxiaozheng
 * @date 2021/9/23 23:07
 */
public interface UserDao {
    //增
    void saveUser(Connection conn,User user);
    //查
    User getUser(Connection conn, User user);
    //校验用户信息
    boolean checkUsername(Connection conn,User user);
}
