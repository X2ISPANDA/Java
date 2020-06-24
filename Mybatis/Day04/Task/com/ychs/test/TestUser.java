package com.ychs.test;

import com.ychs.mapper.MenuMapper;
import com.ychs.mapper.UserMapper;
import com.ychs.pojo.Menu;
import com.ychs.pojo.User;
import com.ychs.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUser {
    @Test
    public void getMenuById() throws IOException {
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getRoleIdById("1");
        MenuMapper mapper1 = sqlSession.getMapper(MenuMapper.class);
        Map map=new HashMap();
        map.put("menuid","0");
        map.put("roleid",user.getRoleid());
        List<Menu> list = mapper1.getMenuByMenuid(map);
//        List<User> list = mapper.getM enuById("1");
        System.out.println(list);
    }
}
