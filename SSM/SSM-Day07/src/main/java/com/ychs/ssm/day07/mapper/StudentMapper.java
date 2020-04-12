package com.ychs.ssm.day07.mapper;

import com.ychs.ssm.day07.model.StudentInfo;

/**
 * @author Mingyu Xiong
 * @description:学生数据模型参数接口
 * @date 2020/3/31 18:32
 */
public interface StudentMapper {
    /**
     * 通过学生id来查询学生信息
     * @param stuId
     * @return
     */
    public StudentInfo selectStudentById(int stuId);
}
