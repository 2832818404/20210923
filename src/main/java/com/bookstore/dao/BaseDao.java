package com.bookstore.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author hongxiaozheng
 * @date 2021/9/23 23:06
 */
public class BaseDao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    // 定义⼀个变量来接收泛型的类型
    private Class<T> type;
    // 获取T的Class对象，获取泛型的类型，泛型是在被⼦类继承时才确定
    public BaseDao() {
        // 获取⼦类的类型
        Class clazz = this.getClass();
        // 获取⽗类的类型
        // getGenericSuperclass()⽤来获取当前类的⽗类的类型
        // ParameterizedType表示的是带泛型的类型
        ParameterizedType parameterizedType = (ParameterizedType)
                clazz.getGenericSuperclass();
        // 获取具体的泛型类型 getActualTypeArguments获取具体的泛型的类型
        // 这个⽅法会返回⼀个Type的数组
        Type[] types = parameterizedType.getActualTypeArguments();
        // 获取具体的泛型的类型·
        this.type = (Class<T>) types[0];


    }

    /*
    * 抽象的写操作，根据传入的sql语句和参数执行操作
    */
    public int update(Connection conn, String sql, Object... params) {
        int count = 0;
        try {
            count = queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    public T getBean(Connection conn,String sql, Object... params) {
        T t = null;
        try {
            t = queryRunner.query(conn, sql, new BeanHandler<T>(type), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return t;
    }
    public List<T> getBeanList(Connection conn, String sql, Object... params) {
        List<T> list = null;
        try {
            list = queryRunner.query(conn, sql, new BeanListHandler<T>(type),
                    params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
