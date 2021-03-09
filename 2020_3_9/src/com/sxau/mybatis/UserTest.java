
package com.sxau.mybatis;
import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserTest {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        String resource = "config.xml";

        //加载mybatis的配置文件
        Reader reader = Resources.getResourceAsReader(resource);

        //构建sqlSession的工县
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);

        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();

        //映射sql的标识字符串
        String statement = "com.sxau.mybatis.userMapper"+".getUser";

        User user = session.selectOne(statement,1);
        System.out.println(user);

    }

}
