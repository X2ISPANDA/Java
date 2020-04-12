package com.ychs.ssm.day07.mapper;

import com.ychs.ssm.day07.model.TeacherInfo;
import com.ychs.ssm.day07.model.TeacherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherInfoMapper {
    long countByExample(TeacherInfoExample example);

    int deleteByExample(TeacherInfoExample example);

    int deleteByPrimaryKey(Integer teacherId);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    List<TeacherInfo> selectByExample(TeacherInfoExample example);

    TeacherInfo selectByPrimaryKey(Integer teacherId);

    int updateByExampleSelective(@Param("record") TeacherInfo record, @Param("example") TeacherInfoExample example);

    int updateByExample(@Param("record") TeacherInfo record, @Param("example") TeacherInfoExample example);

    int updateByPrimaryKeySelective(TeacherInfo record);

    int updateByPrimaryKey(TeacherInfo record);
}