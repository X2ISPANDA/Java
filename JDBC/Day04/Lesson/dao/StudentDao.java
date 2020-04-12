/*
 * Copyright (c) 2019.
 * All Rights Reserved,Designed By Mingyu Xiong
 */

package dao;

import bean.Clazz;
import bean.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import util.DBCPUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mingyu Xiong
 * @description:
 * @date 2019/10/27 10:23
 */
public class StudentDao {
    /**
     * 查询学生通过学号(包括学生的信息,然后加上班级的名称)
     * @param sno
     * @return
     */
    public Student getStudentBySno(String sno) throws SQLException {
        QueryRunner qr = new QueryRunner(DBCPUtil.getDataSource());
        String sql = "select s.*,c.cname from t_student3 s left join t_class c on s.cno=c.cno where s.sno=?";
        Student stu = qr.query(sql, new ResultSetHandler<Student>() {
            @Override
            public Student handle(ResultSet rs) throws SQLException {
                Student stu = new Student();
                while (rs.next()) {
                    stu.setSno(rs.getString("sno"));
                    stu.setSname(rs.getString("sname"));
                    stu.setAge(rs.getInt("age"));
                    stu.setCno(rs.getString("cno"));
                    stu.setCname(rs.getString("cname"));
                    Clazz cla = new Clazz();
                    cla.setCno(rs.getString("cno"));
                    cla.setCname(rs.getString("cname"));
                    stu.setClazz(cla);
                }
                return stu;
            }
        }, new Object[]{sno});
        //Student stu = qr.query(sql, new BeanHandler<Student>(Student.class), new Object[]{sno});
        return stu;
    }


    public List<Student> getStudent(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(DBCPUtil.getDataSource());
        StringBuffer sql = new StringBuffer("select * from t_student3 s left join t_class c on s.cno=c.cno where 1=1");
        List list = new ArrayList();
        if (student.getSname() != null && !"".equals(student.getSname())) {
            sql.append(" and s.sname like ?");
            list.add("%" + student.getSname() + "%");
        }

        if (student.getClazz().getCname() != null && !"".equals(student.getClazz().getCname())) {
            sql.append(" and c.cname like ?");
            list.add("%" + student.getClazz().getCname() + "%");

        }
        List<Student> stuList = queryRunner.query(sql.toString(), new ResultSetHandler<List<Student>>() {
            @Override
            public List<Student> handle(ResultSet rs) throws SQLException {
                List<Student> stu2List = new ArrayList<>();
                while(rs.next()){
                    Student stu = new Student();
                    stu.setSno(rs.getString("sno"));
                    stu.setSname(rs.getString("sname"));
                    stu.setAge(rs.getInt("age"));
                    stu.setCno(rs.getString("cno"));
                    stu.setCname(rs.getString("cname"));
                    Clazz cla = new Clazz();
                    cla.setCno(rs.getString("cno"));
                    cla.setCname(rs.getString("cname"));
                    stu.setClazz(cla);
                    stu2List.add(stu);
                }
                return stu2List;
            }
        }, list.toArray());
        return stuList;
    }
}
