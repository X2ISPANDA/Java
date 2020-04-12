package com.ychs.ssm.day07.mapper;

import com.ychs.ssm.day07.model.Student;

import java.util.List;
import java.util.Map;

/**
 * @author Mingyu Xiong
 * @description:学生数据操作接口,存在一对多映射关系
 * @date 2020/4/1 14:45
 */
public interface Student01Mapper {

    /**
     * 通过id查询学生信息,测试一对多映射关系
     * @param stuId
     * @return
     */
    public Student selectStudentById(int stuId);

    /**
     * 通过map直接封装一对多查询语句的信息
     * @param stuId
     * @return
     */
    public List<Map<String,Object>> selectStudentByMap(int stuId);
}
