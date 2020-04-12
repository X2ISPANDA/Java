package com.ychs.ssm.day07.mapper;

import com.ychs.ssm.day07.model.UserInfo;

import java.util.List;

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
}
