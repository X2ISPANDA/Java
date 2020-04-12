package com.ychs.mapper;

import com.ychs.pojo.School;

import java.util.List;

public interface SchoolMapper {
    public List<School> getSchools(School school);

    public int getCount(School school);
    public int addSchool(School school);
    public int editSchool(School school);
    public int deleteSchool(int id);
    public List<School> getSchoolList();
}
