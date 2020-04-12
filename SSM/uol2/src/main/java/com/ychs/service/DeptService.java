package com.ychs.service;

import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Dept;
import java.util.List;

public interface DeptService {
    public BeanObject<Dept> getDepts(Dept dept);

    public int addDept(Dept dept);

    public List<Dept> getDeptBySchoolId(int schoolId);

    public int deleteDeptByIds(int[] ids);
}
