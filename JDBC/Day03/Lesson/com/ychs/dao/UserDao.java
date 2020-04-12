package com.ychs.dao;

import com.ychs.bean.User;
import com.ychs.util.C3P0Util;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/26 14:44
 */
public class UserDao {
    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //2.准备SQL语句
        String sql = "INSERT INTO t_user values(?,?)";
        //3.执行SQL语句
        int result = qr.update(sql, new Object[]{user.getUsername(), user.getPassword()});
        return result;
    }

    public int editUser(User user) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr = new QueryRunner();
        //2.编写SQL语句
        String sql = "update t_user set password=? where username=?";
        //3.执行SQL
        int result = qr.update(C3P0Util.getConnection(), sql, new Object[]{user.getPassword(),user.getUsername()});
        return result;
    }

    public int deleteUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql = "delete from t_user where username=?";
        int result = qr.update(C3P0Util.getConnection(), sql, new Object[]{user.getUsername()});
        return result;
    }

    public User getUserByUsername(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_user where username=?";
        //BeanHandler 查询出来的对象进行封装
        User result = qr.query(sql, new BeanHandler<>(User.class), new Object[]{username});
        return result;
    }

    public List<User> getUsers(String username) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from t_user where username like ?";
        return qr.query(sql, new BeanListHandler<User>(User.class), new Object[]{"%" + username + "%"});
    }
}
