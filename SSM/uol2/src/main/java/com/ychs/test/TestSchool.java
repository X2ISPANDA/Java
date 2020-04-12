package com.ychs.test;

import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Page;
import com.ychs.pojo.School;
import com.ychs.service.SchoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestSchool {
    @Resource(name = "schoolService")
    private SchoolService schoolService;
    @Test
    public void test01(){
        BeanObject schools = schoolService.getSchools(new School());
        System.out.println(schools.getData());
    }
}
