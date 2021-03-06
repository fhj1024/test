package com.sxau.person;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {

    private static final Properties PROPERTIES  = new Properties();

    static{
        InputStream is = DBUtils.class.getResourceAsStream("db.properties");
        try {
            PROPERTIES.load(is);
            Class.forName(PROPERTIES.getProperty("driver"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(PROPERTIES.getProperty("url"), PROPERTIES.getProperty("username"), PROPERTIES.getProperty("password") );
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public static void closeAll(Connection con, Statement sta, ResultSet res){
        try {
            if(con!=null){
                con.close();
            }
            if(sta!=null){
                con.close();
            }
            if(res!=null){
                res.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


}





















