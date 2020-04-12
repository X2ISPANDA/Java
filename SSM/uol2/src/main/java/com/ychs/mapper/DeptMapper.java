package com.ychs.mapper;

import com.ychs.pojo.Dept;

import java.util.List;
import java.util.Optional;

public interface DeptMapper {
    public List<Dept> getDepts(Dept dept);
    public int getCount(Dept dept);
    public int addDept(Dept dept);
    public List<Dept> getDeptBySchoolId(int schoolId);

    public int deleteDeptByIds(int[] ids);
}
