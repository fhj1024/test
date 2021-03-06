package com.sxau.JDBC2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestOrm {
    public static void main(String[] args){
        Connection con = null;
        PreparedStatement psta = null;
        ResultSet res = null;
        List<Student> stu = new ArrayList<>();

        try {
            con = DBUtils.getConnection();
            psta = con.prepareStatement("select * from student");
            res = psta.executeQuery();

            while(res.next()){
                String id = res.getString("id");
                String name = res.getString("name");
                String address = res.getString("address");
                String phone = res.getString("phone");
                String major = res.getString("major");

                //创建对象，封装查询到的零散数据
                Student student = new Student();
                student.setId(id);
                student.setName(name);
                student.setAddress(address);
                student.setPhone(phone);
                student.setMajor(major);

                //System.out.println(student);

                //每遍历一次得到对象，存放在集合里，方便后续的使用
                stu.add(student);
            }

            //集合遍历
            for (Student s : stu) {
                System.out.println(s);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(con,psta,res);
        }


    }
}
