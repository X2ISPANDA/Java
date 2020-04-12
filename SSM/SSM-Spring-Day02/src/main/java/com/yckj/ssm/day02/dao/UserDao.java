package com.yckj.ssm.day02.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/22 19:45
 */
@Component
public class    UserDao {
    @Autowired 
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser() {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();

        //设置事务的传播行为
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        //设置事务的隔离级别
        transactionDefinition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

        //设置事务的超时时间
        transactionDefinition.setTimeout(10);

        transactionDefinition.setReadOnly(true);

        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);

        try {
            jdbcTemplate.update("INSERT INTO\n" +
                    "user_info\n" +
                    "(id,name,username,password,sex)\n" +
                    "VALUES\n" +
                    "(3,'王五','王五','123123','女')");
            transactionManager.commit(status);
        } catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(status);
        }
    }
}
