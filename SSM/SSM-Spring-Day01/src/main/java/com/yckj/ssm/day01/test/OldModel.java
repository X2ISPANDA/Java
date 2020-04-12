package com.yckj.ssm.day01.test;

import com.yckj.ssm.day01.model.ClassInfo;
import com.yckj.ssm.day01.model.Student;
import com.yckj.ssm.day01.model.Teacher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2020/2/11 16:30
 */
public class OldModel {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1);
        teacher.setName("张三");
        teacher.setAge(18);
        teacher.setSex(true);

        Student student1 = new Student();
        student1.setStuId(1);
        student1.setName("李四");
        student1.setAge(19);
        student1.setSex(true);

        Student student2 = new Student();
        student2.setStuId(2);
        student2.setName("王五");
        student2.setAge(18);
        student2.setSex(true);

        Student student3 = new Student();
        student3.setStuId(3);
        student3.setName("赵六");
        student3.setAge(20);
        student3.setSex(true);

        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassId(1);
        classInfo.setClassCode("java1014");
        classInfo.setTeacher(teacher);

        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        classInfo.setStudentList(studentList);

        System.out.println(classInfo);
    }
}
