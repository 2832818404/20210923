package com.bookstore.beans;

import com.bookstore.dao.UserDao;
import com.bookstore.dao.impl.UserDaoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hongxiaozheng
 * @date 2021/9/24 0:09
 */
public class Test {
    public static void main(String[] args) throws Exception {

        //准备数据库连接
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "001120");
        UserDaoImpl userDao = new UserDaoImpl();
        User haha = new User("haha", "111", "666@.com");


        userDao.saveUser(connection , haha);
    }
}
