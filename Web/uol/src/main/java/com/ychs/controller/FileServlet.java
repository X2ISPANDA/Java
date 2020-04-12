/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package com.ychs.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/12/23 21:39
 */
@WebServlet(name = "FileServlet", urlPatterns = "/file")
public class FileServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String method = request.getParameter("method");
        if ("uploadFile".equals(method)) {
            uploadFile(request, response);
        } else if ("downloadFile".equals(method)) {
            downloadFile(request, response);
        }

    }

    private void downloadFile(HttpServletRequest request, HttpServletResponse response) {
    }

    private void uploadFile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("uploadFile.jsp").forward(request, response);
        //创建工厂
        DiskFileItemFactory dfif = new DiskFileItemFactory();
        //使用工厂创建解析对象
        ServletFileUpload upload = new ServletFileUpload(dfif);
        //使用解析器对象解析request，得到FileItem列表
        try {
            List<FileItem> fileItems = upload.parseRequest(request);
            //遍历表单项
            for (FileItem fileItem : fileItems) {
                //如果是普通项
                if (fileItem.isFormField()) {
                    String fieldName = fileItem.getFieldName();
                    response.getWriter().write(fieldName + ":" + fileItem.getString() + "<br/>");
                } else {
                    //如果上传的是文件
                    String name = fileItem.getName();
                    System.out.println("上传文件的名称" + name);
                    request.setAttribute("name", name);
                    //获取真实路径
                    String realPath = this.getServletContext().getRealPath("/upload");
                    System.out.println("保存路径" + realPath);
                    //创建file对象，通过真实路径和文件名称
                    File file = new File(realPath, name);
                    //把上传文件保存到指定位置
                    fileItem.write(file);
                    response.getWriter().write("上传文件的名称：" + fileItem.getName() + "<br/>");
                    response.getWriter().write("上传文件的大小" + fileItem.getSize() + "<br/>");
                    response.getWriter().write("上传文件的类型" + fileItem.getContentType());
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


