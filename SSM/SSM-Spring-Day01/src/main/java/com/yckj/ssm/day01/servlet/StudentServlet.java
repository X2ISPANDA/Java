package com.yckj.ssm.day01.servlet;

import com.yckj.ssm.day01.services.StudentServices;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/13 15:46
 */
public class StudentServlet {
    //private StudentServices studentServices = new StudentServices();
    private StudentServices studentServices;

    public void services() {
        studentServices.addStudent();
    }

    public StudentServices getStudentServices() {
        return studentServices;
    }

    public void setStudentServices(StudentServices studentServices) {
        this.studentServices = studentServices;
    }
}
