package read.app;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import read.mybatis.mapper.UserMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by JAVA on 2018/7/24.
 */
public class App {
    final static String conf = "D:\\000学习\\mybatis源码\\mybatis\\read-mybatis\\src\\main\\resources\\generator\\mybatis-config.xml";
    //
    public static void main(String[] args) throws FileNotFoundException {
        InputStream configFile = new FileInputStream(conf);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.insert("1111");

    }

}
