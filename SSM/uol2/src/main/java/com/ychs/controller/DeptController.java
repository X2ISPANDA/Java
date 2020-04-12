package com.ychs.controller;

import com.alibaba.fastjson.JSON;
import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Dept;
import com.ychs.service.DeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;

@Controller
@RequestMapping(value = "/dept")
public class DeptController {
    @Resource(name = "deptService")
    private DeptService deptService;
    private Logger logger = Logger.getLogger(DeptController.class);
    @RequestMapping(value = "/getDepts")
    public void getDepts(Dept dept, HttpServletResponse response) throws IOException {
//    public @ResponseBody BeanObject getDepts(Dept dept) throws IOException {
        System.out.println("中国人的。。。。。。");
        response.setContentType("text/html;charset=UTF-8");
        BeanObject<Dept> depts = deptService.getDepts(dept);
        String deptJson = JSON.toJSONString(depts);
        System.out.println("deptJson="+deptJson);
        response.getWriter().write(deptJson);
//        return depts;
    }

    @RequestMapping(value = "/addDept")
    public String addDept(Dept dept){
        int result = deptService.addDept(dept);
        if(result>0){
            return "dept/queryDept";
        }else{
            logger.debug("添加失败");
            return null;
        }

    }
    @RequestMapping(value = "/getDeptBySchoolId")
    public @ResponseBody List<Dept> getDeptBySchoolId(Integer schoolId){
        return deptService.getDeptBySchoolId(schoolId);
    }
    @RequestMapping(value = "/deleteDeptByIds")
    public @ResponseBody int deleteDeptByIds(@RequestParam(value = "ids[]") int[] ids){
        return deptService.deleteDeptByIds(ids);

    }

}
