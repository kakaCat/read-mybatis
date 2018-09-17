package app;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import read.mybatis.mapper.UserMapper;

import java.io.IOException;

/**
 * Created by JAVA on 2018/7/24.
 */
public class AppBean {



    @Test
    public void app() throws IOException {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://47.98.147.125:3306/dome1?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        // 事务管理器
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);

        // 注册指定映射器
        configuration.addMapper(UserMapper.class);
        // 注册映射器类所在包名下的所有映射器
        //configuration.addMappers("org.chench.test.mybatis.mapper.impl");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession();


        int user  = sqlSession.selectOne("read.mybatis.mapper.UserMapper.insert","11");


    }


}
