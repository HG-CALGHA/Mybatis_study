package com.mybatis03.cache.controller;

import com.mybatis03.cache.entity.Employee;
import com.mybatis03.cache.impl.imi.MyBatisCache;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @ClassName CacheTestController
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/17 19:44
 * @Version 1.0
 */

@Controller
public class CacheTestController {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @RequestMapping("test1")
    @ResponseBody
    public String testFirstLevelCache() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisCache myBatisCache = openSession.getMapper(MyBatisCache.class);
            List<Employee> empById1 = myBatisCache.getEmpById(1);

            openSession.clearCache();

            List<Employee> empById2 = myBatisCache.getEmpById(1);

            System.out.println("cc1:" + empById1);
            System.out.println("cc2:" + empById2);
        } finally {
            openSession.close();

        }

        return "1";

    }

    @RequestMapping("test2")
    @ResponseBody
    public String testFirstLevelCache2() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        SqlSession openSession2 = sqlSessionFactory.openSession();
        try {
            MyBatisCache myBatisCache = openSession.getMapper(MyBatisCache.class);
            MyBatisCache myBatisCaches = openSession2.getMapper(MyBatisCache.class);

            List<Employee> empById1 = myBatisCache.getEmpById(1);



            List<Employee> empById2 = myBatisCaches.getEmpById(1);

            System.out.println("cc1:" + empById1);
            System.out.println("cc2:" + empById2);
        } finally {
            openSession.close();
            openSession2.close();
        }

        return "1";

    }


}
