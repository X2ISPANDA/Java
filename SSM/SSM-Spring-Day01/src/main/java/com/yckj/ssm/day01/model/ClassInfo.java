package com.yckj.ssm.day01.model;

import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:班级数据模型
 * @date 2020/2/11 16:28
 */
public class ClassInfo {
    private int classId;

    private String classCode;

    private Teacher teacher;

    private List<Student> studentList;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", classCode='" + classCode + '\'' +
                ", teacher=" + teacher +
                ", studentList=" + studentList +
                '}';
    }
}
