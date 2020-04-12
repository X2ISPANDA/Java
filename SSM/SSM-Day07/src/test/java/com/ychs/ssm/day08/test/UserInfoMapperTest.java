package com.ychs.ssm.day08.test;

import com.ychs.ssm.day07.mapper.UserInfoMapper;
import com.ychs.ssm.day07.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/3/26 18:37
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void selectUserInfoTest() {
        List<UserInfo> userInfoList = userInfoMapper.selectUserInfo();
        System.out.println(userInfoList);
    }

    @Test
    public void selectUserByCond() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wrx");
        userInfo.setPassword("123");
        UserInfo outUserInfo = userInfoMapper.selectUserByCond(userInfo);
        System.out.println("-----------------" + outUserInfo);
    }

    @Test
    public void selectUserByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("username", "wrx");
        map.put("password", "123");
        UserInfo userInfo = userInfoMapper.selectUserByMap(map);
        System.out.println("-----------------" + userInfo);
    }

    @Test
    public void insertUserTest() {
        UserInfo userInfo = new UserInfo();
//      userInfo.setId(6);
        userInfo.setUsername("xmy");
        userInfo.setPassword("123");
        userInfo.setName("xmy");
        userInfo.setSex("男");
        int i = userInfoMapper.insertUser(userInfo);
        System.out.println(i);
        System.out.println(userInfo.getId());
    }

    @Test
    public void updateUserMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 7);
        map.put("name", "熊铭钰");
        map.put("username", "xmy329");
        map.put("password", "0329");
        map.put("sex", "男");
        userInfoMapper.updateUserMap(map);
    }

    @Test
    public void selectUserByCond01Test() {
        UserInfo userInfo = new UserInfo();
        userInfo.setName("wrx");
        List<UserInfo> userInfoList = userInfoMapper.selectUserByCond01(userInfo);
        System.out.println(userInfoList);
    }

    @Test
    public void updateUserMultipleTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(6);
        userInfo.setUsername("zxh");
        userInfo.setPassword("132");
        userInfoMapper.updateUserMultiple(userInfo);
    }

    @Test
    public void selectUserByIdListTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);

        List<UserInfo> userInfoList = userInfoMapper.selectUserByIdList(list);
        System.out.println(userInfoList);
    }

    @Test
    public void selectUserOrderByIdTest() {
        List<UserInfo> userInfoList = userInfoMapper.selectUserOrderById("DESC");
        System.out.println(userInfoList);
    }

    @Test
    public void selectUserByLikeTest() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "x");
        List<UserInfo> userInfoList = userInfoMapper.selectUserByLike(map);
        System.out.println(userInfoList);
    }

    @Test
    public void selectUserByIdTest() {
        Integer integer = new Integer(4);
        List<UserInfo> userInfoList = userInfoMapper.selectUserById(integer);
        System.out.println(userInfoList);
    }
}
