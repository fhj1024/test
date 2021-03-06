package com.sxau.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) throws Exception {
        //1、加载驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2、获得连接对象
        String url = "jdbc:mysql://localhost:3306/university";
        String user = "root";
        String pws = "root";
        Connection con = DriverManager.getConnection(url,user,pws);

        if(con!=null){
            System.out.println("数据库连接成功哦！");
        }else{
            System.out.println("数据库连接失败！");
        }

        //3、获得执行sql语句的对象
        Statement sta = con.createStatement();

        //4、编写sql语句，执行sql语句
        String sql = "insert into student(id,name,gender,address,phone,major) values('2','gj','nv','fs','133456','huiji')";
        int result = sta.executeUpdate(sql);

        //5、处理结果
        if(result==1){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }

        //6、释放资源
        sta.close();
        con.close();

    }
}
