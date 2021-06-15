package com.example.generator.controller;

import dao.EmployeeMapper;
import entity.Employee;
import entity.EmployeeExample;
import entity.EmployeeExample.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/22 15:39
 * @Version 1.0
 */
@RestController
public class TestController {

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "dao/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

//    @RequestMapping("test")
//    public List<entity.Employee> test() throws InterruptedException, SQLException, IOException, XMLParserException, InvalidConfigurationException {
//        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
//        SqlSession openSession = sqlSessionFactory.openSession();
//        List<entity.Employee> employees;
//        try {
//            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
//            employees = mapper.selectAll();
//            System.out.println();
//            for (entity.Employee employee : employees) {
//                System.out.println(employee.getId());
//            }
//        }finally {
//            openSession.close();
//        }
//        return employees;
//    }

    @RequestMapping("test2")
    public List<entity.Employee> test() throws InterruptedException, SQLException, IOException, XMLParserException, InvalidConfigurationException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        List<entity.Employee> employees;
        List<Employee> employeeList;
        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            employeeList = mapper.selectByExample(null);
        }finally {
            openSession.close();
        }
        return employeeList;
    }

}
