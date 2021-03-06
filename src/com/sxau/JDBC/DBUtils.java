package com.sxau.JDBC;


import java.sql.*;

public class DBUtils {
    //类加载，执行一次，检查一次
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //1、获取连接
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    //2、释放资源
    public static void closeAll(Connection con, Statement sta, ResultSet res){
        if(res!=null){
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(sta!=null){
            try {
                sta.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(res!=null){
            try {
                res.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
