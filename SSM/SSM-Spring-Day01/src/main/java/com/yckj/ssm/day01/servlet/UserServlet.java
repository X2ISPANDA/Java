package com.yckj.ssm.day01.servlet;

import com.yckj.ssm.day01.dao.SchoolDao;
import com.yckj.ssm.day01.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/13 12:56
 */
@Component("userServlet")
public class UserServlet implements Servlet {
    //private UserServices userServices = new UserServices();
    @Autowired
    private UserServices userServices;

    private SchoolDao schoolDao;
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet请求开始!");
        userServices.addUser();
        System.out.println("Servlet请求结束! ");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    public UserServices getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServices userServices) {
        this.userServices = userServices;
    }

    public SchoolDao getSchoolDao() {
        return schoolDao;
    }

    public void setSchoolDao(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }
}
