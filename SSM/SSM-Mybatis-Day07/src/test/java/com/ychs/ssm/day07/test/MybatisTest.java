package com.ychs.ssm.day07.test;

import com.ychs.ssm.day07.mapper.UserInfoMapper;
import com.ychs.ssm.day07.model.UserInfo;
import com.ychs.ssm.day07.utils.MybatisDBUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/3/22 11:45
 */
public class MybatisTest {

    @Test
    public void test01() {
        /*获取一个Myabtis类型的SQL会话对象*/
        SqlSession sqlSession = MybatisDBUtils.getSession();
        UserInfoMapper userInfoMapper = sqlSession.getMapper(UserInfoMapper.class);
        List<UserInfo> userInfoList = userInfoMapper.selectUserInfo();
        System.out.println(userInfoList);
    }
}
