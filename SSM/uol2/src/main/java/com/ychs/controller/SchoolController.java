package com.ychs.controller;

import com.ychs.pojo.BeanObject;
import com.ychs.pojo.Page;
import com.ychs.pojo.School;
import com.ychs.service.SchoolService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/school")
public class SchoolController {
    @Resource(name = "schoolService")
    private SchoolService schoolService;

    @RequestMapping(value = "/getSchools")
    public @ResponseBody BeanObject getSchools(School school){
        BeanObject bean = schoolService.getSchools(school);
        return bean;
    }
    @RequestMapping(value = "/addSchool")
    public @ResponseBody int addSchool(School school){
        int i = schoolService.addSchool(school);
        System.out.println(i);
        return i;
    }
    @RequestMapping(value = "/delSchool")
    public @ResponseBody int delSchool(int id){
        return schoolService.delSchool(id);
    }
    @RequestMapping(value = "/editSchool")
    public @ResponseBody int editSchool(School school){
        return schoolService.editSchool(school);
    }
    @RequestMapping(value = "/getSchoolList")
    public @ResponseBody List<School> getSchoolList(){
        return schoolService.getSchoolList();
    }
}
