package com.sxau.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginJdbc2 {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入id号：");
        String id = input.nextLine();
        System.out.println("请输入名字：");
        String name = input.nextLine();

        //Class.forName("com.mysql.jdbc.Driver");
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
        Connection con = DBUtils.getConnection();


        //获得PreparedStatement对象和预编译sql语句
        PreparedStatement psta = con.prepareStatement("select * from student where id=? and name=?");

        //为占位符？赋值
        psta.setString(1,id);
        psta.setString(2,name);

        //执行sql语句并接收结果
        ResultSet rs = psta.executeQuery();
        if(rs.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        //rs.close();
        //psta.close();
        //con.close();
        DBUtils.closeAll(con,psta,rs);

    }
}
