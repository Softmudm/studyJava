package com.sz.zhiling.service;

import com.sz.zhiling.entity.Student;
import com.sz.zhiling.util.jdbcutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class studentService {
    //查询全部学生
    public List<Student> selectAllStudent(){
        Connection cn = jdbcutil.getConnection();
        String sql = "select * from tblstudent";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        try {
            ps = cn.prepareStatement(sql);
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
}