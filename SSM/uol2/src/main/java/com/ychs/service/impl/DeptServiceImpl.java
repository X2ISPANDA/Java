package com.ychs.service.impl;

import com.ychs.mapper.DeptMapper;
import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Dept;
import com.ychs.service.DeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "deptService")
public class DeptServiceImpl implements DeptService {
    @Resource(name = "deptMapper")
    private DeptMapper deptMapper;
    @Override
    public BeanObject<Dept> getDepts(Dept dept) {
        List<Dept> depts = deptMapper.getDepts(dept);
        int count = deptMapper.getCount(dept);
        BeanObject<Dept> bean = new BeanObject<>();
        bean.setData(depts);
        bean.setCount(count);
        return bean;
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public List<Dept> getDeptBySchoolId(int schoolId) {
        return deptMapper.getDeptBySchoolId(schoolId);
    }

    @Override
    public int deleteDeptByIds(int[] ids) {
        return deptMapper.deleteDeptByIds(ids);
    }
}
