package com.yckj.ssm.day02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/23 15:24
 */
@Component
public class UserDao01 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser() {
        jdbcTemplate.update("INSERT INTO\n" +
                "user_info\n" +
                "(id,name,username,password,sex)\n" +
                "VALUES\n" +
                "(4,'王五','王五','123123','女')");
    }

    public List<Map<String, Object>> selectUser() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("SELECT\n" +
                "*\n" +
                "FROM\n" +
                "user_info");
        return list;
    }
}
