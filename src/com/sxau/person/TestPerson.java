package com.sxau.person;

import java.sql.ResultSet;
import java.util.List;

public class TestPerson {



    public static void main(String[] args){
        PersonDaoImpl pdi = new PersonDaoImpl();
        //TestPerson.testInsert(pdi);
        //TestPerson.testUpdate(pdi);
        //TestPerson.testDelete(pdi);
        //TestPerson.testQuery(pdi);
        TestPerson.testAllQuery(pdi);
    }

    public static void testInsert(PersonDaoImpl pdi){
        Person person = new Person("范公子",20,null,"166@qq.com","忻州");
        int result = pdi.insert(person);
        if(result==1){
            System.out.println("增加成功！");
        }else{
            System.out.println("增加失败！");
        }
    }
    public static void testUpdate(PersonDaoImpl pdi){
        Person person = new Person(3,"李公子",33,null,"176@qq.com","大同");
        int result = pdi.update(person);
        if(result==1){
            System.out.println("修改成功！");
        }else{
            System.out.println("修改失败！");
        }
    }
    public static void testDelete(PersonDaoImpl pdi){
        int result = pdi.delete(3);
        if(result==1){
            System.out.println("删除成功！");
        }else{
            System.out.println("删除失败！");
        }
    }

    public static void testQuery(PersonDaoImpl pdi){
        Person person = pdi.select(4);
        if(person!=null){
            System.out.println(person);
        }else{
            System.out.println("没有查到该用户!");
        }
    }

    public static void testAllQuery(PersonDaoImpl pdi){
        List<Person> lp = pdi.selectAll();
        for (Person p:lp
             ) {
            System.out.println(p);
        }
    }

}
