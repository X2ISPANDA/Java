package com.ychs.ssm.day07.mapper;

import com.ychs.ssm.day07.model.UserInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:Mybatis user_info表数据操作映射接口
 * @date 2020/3/21 20:00
 */
public interface UserInfoMapper {
    /**
     * 无条件查询user_info表的所有记录
     * @return
     */
    public List<UserInfo> selectUserInfo();

    /**
     * 通过用户名查询用户信息
     * @param username
     * @return
     */
    public UserInfo selectUserByName(String username);

    /**
     * 使用pojo通过用户名和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo selectUserByCond(UserInfo userInfo);

    /**
     * 使用户Map通过用户名和密码查询用户信息
     * @param userInfo
     * @return
     */
    public UserInfo selectUserByMap(Map userInfo);

    /**
     * 添加用户记录
     * @param userInfo
     */
    public int insertUser(UserInfo userInfo);

    /**
     * 通过id来修改用户信息
     * @param map
     * @return
     */
    public int updateUserMap(HashMap<String, Object> map);

    /**
     * 多条件动态查询用户信息
     *
     * @param userInfo
     * @return
     */
    public List<UserInfo> selectUserMultiple(UserInfo userInfo);

    /**
     * 测试choose标签的使用
     * @param userInfo
     * @return
     */
    public List<UserInfo> selectUserByCond01(UserInfo userInfo);

    /**
     * 测试set标签的使用
     * @param userInfo
     * @return
     */
    public int updateUserMultiple(UserInfo userInfo);

    /**
     * 测试foreach标签的使用
     * @param list
     * @return
     */
    public List<UserInfo> selectUserByIdList(List<Integer> list);

    /**
     * 测试Mybatis变量值的处理方式
     * @param orderByType
     * @return
     */
    public List<UserInfo> selectUserOrderById(String orderByType);

    /**
     * 模糊查询语句的使用测试
     * @param map
     * @return
     */
    public List<UserInfo> selectUserByLike(Map<String,String> map);

    /**
     * 测试特殊符号的原样输出
     * @param id
     * @return
     */
    public List<UserInfo> selectUserById(Integer id);
}
