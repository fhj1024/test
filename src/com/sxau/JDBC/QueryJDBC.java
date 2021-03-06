package com.sxau.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class QueryJDBC {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/university","root","root");
        Statement sta = con.createStatement();
        ResultSet rs = sta.executeQuery("select * form student");
        while(rs.next()){
            String id = rs.getString("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String major = rs.getString("major");
        }

        rs.close();
        sta.close();
        con.close();
    }

}
