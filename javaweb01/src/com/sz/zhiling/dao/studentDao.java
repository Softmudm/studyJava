package com.sz.zhiling.dao;

import com.sz.zhiling.entity.Student;
import com.sz.zhiling.util.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentDao {

    //模糊查询学生
    public List<Student> selectStudent(String keyword){
        Connection cn = jdbcutil.getConnection();
        String sql = "select * from tblstudent where stuid like ? or stuname like ? or stuage like ? or stusex like ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        keyword = "%"+keyword+"%";
        try {
            ps = cn.prepareStatement(sql);
            for(int i=1;i<=4;i++){
                ps.setString(i,keyword);
            }
            rs = ps.executeQuery();
            while(rs.next()){
                Student student = new Student(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4));
                list.add(student);
            }
            return list;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.closeAll(rs,ps,cn);
        }
        return null;
    }

    //添加学生
    public int addStudent(Student student){
        Connection cn = jdbcutil.getConnection();
        String sql = "insert into tblstudent values(?,?,?,?)";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,student.getStuid());
            ps.setString(2,student.getStuname());
            ps.setInt(3,student.getAge());
            ps.setString(4,student.getStusex());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.closeAll(null,ps,cn);
        }
        return 0;
    }

    //根据id删除学生
    public int deleteStudentById(String stuid){
        Connection cn = jdbcutil.getConnection();
        String sql = "delete from tblstudent where stuid=?";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,stuid);
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.closeAll(null,ps,cn);
        }
        return 0;
    }

    //修改学生
    public int updateStudent(Student student){
        Connection cn = jdbcutil.getConnection();
        String sql = "update tblstudent set stuname=?,stuage=?,stusex=? where stuid=?";
        PreparedStatement ps = null;
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1,student.getStuname());
            ps.setInt(2,student.getAge());
            ps.setString(3,student.getStusex());
            ps.setString(4,student.getStuid());
            return ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            jdbcutil.closeAll(null,ps,cn);
        }
        return 0;
    }
}