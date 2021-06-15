package com.mybatis.day01test.controller;

import com.mybatis.day01test.entity.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class MyBatisController {

    @GetMapping("/test")
    @ResponseBody
    public Employee MyBatisText() throws IOException {
        Employee employee;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));

        SqlSession openSession = sqlSessionFactory.openSession();

        try{
            employee = openSession.selectOne("mybatis-BlogMapper.xml.selectBlog", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
        return employee;
    }

}