package com.ychs.service;

import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Page;
import com.ychs.pojo.School;

import java.util.List;

public interface SchoolService {
    public BeanObject getSchools(School school);
    public int addSchool(School school);

    public int delSchool(int id);

    public int editSchool(School school);

    public List<School> getSchoolList();
}
