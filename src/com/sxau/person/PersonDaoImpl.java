package com.sxau.person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonDaoImpl {

    public int insert(Person person){
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "insert into stu (name,age,bornDate,email,address) values(?,?,?,?,?)";

        try {
            con = DBUtils.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,person.getName());
            pst.setInt(2,person.getAge());
            pst.setDate(3,null);
            pst.setString(4, person.getEmail());
            pst.setString(5,person.getAddress());
            int result = pst.executeUpdate();
            return result;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(con,pst,null);
        }
        return 0;
    }

    public int update(Person person){
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "update stu set name=?,age=?,bornDate=?,email=?,address=? where id=?";

        try {
            con = DBUtils.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,person.getName());
            pst.setInt(2,person.getAge() );
            pst.setDate(3,null);
            pst.setString(4,person.getEmail() );
            pst.setString(5,person.getAddress());
            pst.setInt(6,person.getId());
            int result = pst.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(con,pst,null);
        }

        return 0;
    }

    public int delete(int id){
        Connection con = null;
        PreparedStatement pst = null;
        String sql = "delete from stu where id=?";

        try {
            con = DBUtils.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            int result = pst.executeUpdate();
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(con,pst,null);
        }
        return 0;
    }

    public Person select(int id){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from stu where id=?";
        Person person = null;
        try {
            con = DBUtils.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            rs = pst.executeQuery();
            if(rs.next()){
                int pid = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Date bornDate = rs.getDate("bornDate");
                String email = rs.getString("email");
                String address = rs.getString("address");

                person = new Person(pid,name,age,bornDate,email,address);
            }
            return person;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(con,pst,rs);
        }
        return null;
    }

    public List<Person> selectAll(){
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "select * from stu";
        Person person;
        List<Person> personList = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                person = new Person();
                person.setId( rs.getInt("id"));
                person.setName( rs.getString("name"));
                person.setBornDate( rs.getDate("bornDate"));
                person.setEmail( rs.getString("email"));
                person.setAddress( rs.getString("address"));

                personList.add(person);
            }
            return personList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(con,pst,rs);
        }

        return null;
    }

}
