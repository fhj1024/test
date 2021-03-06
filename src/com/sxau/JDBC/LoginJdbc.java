package com.sxau.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LoginJdbc {
    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);
        System.out.println("请输入id号：");
        String id = input.nextLine();
        System.out.println("请输入姓名：");
        String name = input.nextLine();

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
        Statement sta  = con.createStatement();
        ResultSet rs = sta.executeQuery("select * from student where id='"+id+"' and name='"+name+"'");

        if(rs.next()){
            System.out.println("登录成功！");
        }else{
            System.out.println("登录失败！");
        }

        rs.close();
        sta.close();
        con.close();

    }
}
