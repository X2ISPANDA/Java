package com.ychs.service.impl;

import com.ychs.mapper.SchoolMapper;
import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Page;
import com.ychs.pojo.School;
import com.ychs.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "schoolService")
public class SchoolServiceImpl implements SchoolService {

    @Resource
    private SchoolMapper schoolMapper;
    @Override
    public BeanObject getSchools(School school) {
        List<School> schools = schoolMapper.getSchools(school);
        int count = schoolMapper.getCount(school);

        BeanObject bean = new BeanObject();
        bean.setData(schools);
        bean.setCount(count);
        return bean;
    }

    @Override
    public int addSchool(School school) {
        int i = schoolMapper.addSchool(school);
        return i;
    }

    @Override
    public int delSchool(int id) {
        return schoolMapper.deleteSchool(id);
    }

    @Override
    public int editSchool(School school) {
        return schoolMapper.editSchool(school);
    }

    @Override
    public List<School> getSchoolList() {
        List<School> schoolList = schoolMapper.getSchoolList();
        return schoolList;
    }


}
