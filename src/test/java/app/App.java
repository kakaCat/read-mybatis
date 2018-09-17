package app;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import read.mybatis.mapper.UserMapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by James on 2017-09-08.
 * From 咕泡学院出品
 * 老师咨询 QQ 2904270631
 */

public class App {
    final static String conf = "D:\\000学习\\mybatis源码\\mybatis\\read-mybatis\\src\\main\\resources\\generator\\mybatis-config.xml";
//    @Before
//    public SqlSession getSqlSession() throws FileNotFoundException {
//        //配置文件
//        InputStream configFile = new FileInputStream(conf);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
//        //加载配置文件得到SqlSessionFactory
//        return sqlSessionFactory.openSession();
//    }


    @Test
    public void app() throws FileNotFoundException {


        InputStream configFile = new FileInputStream(conf);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Configuration configuration = sqlSession.getConfiguration();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//        int result =  userMapper.insert("1111");

        int result =  userMapper.select();

        int result2 =  userMapper.select();
//        System.out.println(user.toString());

    }



//    public static SqlSession getSqlSession() throws FileNotFoundException {
//        //配置文件
//        InputStream configFile = new FileInputStream(
//                conf);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configFile);
//        //加载配置文件得到SqlSessionFactory
//        return sqlSessionFactory.openSession();
//    }
//
//    public static void main(String[] args) throws FileNotFoundException {
//        TestMapper testMapper = getSqlSession().getMapper(TestMapper.class);
//        Test test = testMapper.selectByPrimaryKey(1);
//        /**
//         * 1. 找到SQL
//         * 2. 参数设置
//         * 3. 执行
//         * 4. 结果映射
//         */
//
//
//    }
}
