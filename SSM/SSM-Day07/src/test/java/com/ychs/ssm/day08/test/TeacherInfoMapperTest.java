package com.ychs.ssm.day08.test;

import com.ychs.ssm.day07.mapper.TeacherInfoMapper;
import com.ychs.ssm.day07.model.TeacherInfo;
import com.ychs.ssm.day07.model.TeacherInfoExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:测试MybatisGenerator
 * @date 2020/4/1 17:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class TeacherInfoMapperTest {

    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    @Test
    public void insertTest() {
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setName("李四");
        teacherInfo.setAge(18);
        teacherInfo.setSex("男");
/*        teacherInfo.setTeacherType("java");
        teacherInfo.setRemark("张三");*/
        //teacherInfoMapper.insert(teacherInfo);
        teacherInfoMapper.insertSelective(teacherInfo);
    }

    @Test
    public void updateTest() {
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setName("王睿希");
        teacherInfo.setTeacherId(2);
        teacherInfo.setAge(19);
        teacherInfo.setSex("女");
        //teacherInfoMapper.updateByPrimaryKey(teacherInfo);
        //teacherInfoMapper.updateByPrimaryKeySelective(teacherInfo);
        //teacherInfoMapper.updateByExample();
        //teacherInfoMapper.updateByExampleSelective();/**/
    }

    @Test
    public void deleteTest() {
        //teacherInfoMapper.deleteByPrimaryKey(1);
        //teacherInfoMapper.deleteByExample();
    }

    @Test
    public void selectTest() {
        /*TeacherInfo teacherInfo = teacherInfoMapper.selectByPrimaryKey(3);
        System.out.println(teacherInfo);*/
        TeacherInfoExample example = new TeacherInfoExample();
       // example.createCriteria().andNameEqualTo("王睿希").andSexEqualTo("女").andAgeEqualTo(19);
        //example.createCriteria().andAgeBetween(18, 20);
        example.createCriteria().andNameLike("%王%");
        List<TeacherInfo> teacherInfos = teacherInfoMapper.selectByExample(example);
        System.out.println(teacherInfos);
    }
}
