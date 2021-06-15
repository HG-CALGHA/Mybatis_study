package com.mybatisday02.properties.controller;

import com.mybatisday02.properties.emtity.Department;
import com.mybatisday02.properties.emtity.Employee;
import com.mybatisday02.properties.imi.MyBatisDepartmentInterface;
import com.mybatisday02.properties.imi.MyBatisDynamicSQL;
import com.mybatisday02.properties.imi.MyBatisInterface;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class MyBatisController {

    @GetMapping("/test")
    @ResponseBody
    public Employee MyBatisText() throws IOException {
        Employee employee;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession openSession = sqlSessionFactory.openSession();

        try{
            employee = openSession.selectOne("mybatis-BlogMapper.xml.selectBlog", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
        return employee;
    }

    private SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }


    @RequestMapping("/tests")
    @ResponseBody
    public Employee MyMyBatisTexts() throws IOException {
        Employee employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpById(5);
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/test1s")
    @ResponseBody
    public String MyBatisAddText1s() throws IOException {
        Employee employee = new Employee();
        employee.setEmail("CC@qq.com");
        employee.setGender("40");
        employee.setLastName("cc");
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        System.out.println(employee.toString());
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            myBatisInterface.addEmp(employee);
//            openSession.commit();
            System.out.println(employee.toString());
        }finally {
            openSession.close();
        }

        return "111";
    }

    @RequestMapping("/test2s")
    @ResponseBody
    public String MyBatisUpDataText1s() throws IOException {
        Employee employee = new Employee();
        employee.setEmail("CC@qq.com");
        employee.setGender("1000");
        employee.setLastName("cc");
        employee.setId(2);
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession(true);
        System.out.println(employee.toString());
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            myBatisInterface.upDataEmp(employee);
//            openSession.commit();
        }finally {
            openSession.close();
        }

        return "111";
    }

    @RequestMapping("/test3s")
    @ResponseBody
    public String MyBatisDeleteText1s() throws IOException {

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            myBatisInterface.deleteEmpById(2);
            openSession.commit();
        }finally {
            openSession.close();
        }

        return "111";
    }

    @RequestMapping("/test4s")
    @ResponseBody
    public Map<String,Object> MyBatisDeleteText4s() throws IOException {
        Map<String,Object> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpByIdAndlastName(1,"tom");
            openSession.commit();
        }finally {
            openSession.close();
        }

        return employee;
    }

    @RequestMapping("/test5s")
    @ResponseBody
    public Map<Integer,Employee> MyBatisDeleteText5s() throws IOException {
        Map<Integer, Employee> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpByLastName("%c%");
            openSession.commit();
        }finally {
            openSession.close();
        }

        return employee;
    }


    @RequestMapping("/test6s")
    @ResponseBody
    public Employee MyBatisDeleteText6s() throws IOException {
        Employee employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpAndDept(9);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }
    @RequestMapping("/test7s")
    @ResponseBody
    public Employee MyBatisDeleteText7s() throws IOException {
        Employee employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface=openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpByIdStep(1);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/test8s")
    @ResponseBody
    public Department MyBatisDeleteText8s() throws IOException {
        Department employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDepartmentInterface myBatisInterface=openSession.getMapper(MyBatisDepartmentInterface.class);
            employee = myBatisInterface.departByIdPlus(1);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/test9s")
    @ResponseBody
    public List<Employee> MyBatisLastNameText9s() throws IOException {
        List<Employee> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface = openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpByLastNameLike("%c%");
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }


    @RequestMapping("/testsss")
    @ResponseBody
    public Department MyBatisDeleteTextss() throws IOException {
        Department employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDepartmentInterface myBatisInterface=openSession.getMapper(MyBatisDepartmentInterface.class);
            employee = myBatisInterface.departById(1);
            System.out.println(employee);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/testes")
    @ResponseBody
    public Employee MyBatisLastNameText11s() throws IOException {
        Employee employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisInterface myBatisInterface = openSession.getMapper(MyBatisInterface.class);
            employee = myBatisInterface.getEmpByIds(8);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }


    @RequestMapping("/test12s")
    @ResponseBody
    public List<Employee> MyBatisLastNameText12s(Employee employees) throws IOException {
        List<Employee> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDynamicSQL mapper = openSession.getMapper(MyBatisDynamicSQL.class);
                System.out.println(employees.getGender().equals(0));
            employee =  mapper.getEmpByConditionIf(employees);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/test13s")
    @ResponseBody
    public List<Employee> MyBatisLastNameText13s(Employee employees) throws IOException {
        List<Employee> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDynamicSQL mapper = openSession.getMapper(MyBatisDynamicSQL.class);
            System.out.println(employees);
            employee =  mapper.getEmpByConditionChoose(employees);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/test14s")
    @ResponseBody
    public String MyBatisLastNameText14s(Employee employees) throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDynamicSQL mapper = openSession.getMapper(MyBatisDynamicSQL.class);
            System.out.println(employees);
            mapper.upDataEmpByCondition(employees);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return "employee";
    }

    @RequestMapping("/test15s")
    @ResponseBody
    public List<Employee> MyBatisLastNameText15s() throws IOException {
        List<Employee> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDynamicSQL mapper = openSession.getMapper(MyBatisDynamicSQL.class);
            employee =  mapper.departByIdSteps(Arrays.asList(1,5,9,7));
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }

    @RequestMapping("/test16s")
    @ResponseBody
    public String  MyBatisLastNameText16s() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDynamicSQL mapper = openSession.getMapper(MyBatisDynamicSQL.class);
            ArrayList<Employee> employees = new ArrayList<>();
            employees.add(new Employee(null,"asfgd","0","fad",0));
            employees.add(new Employee(null,"asd2","1","fad",1));
            employees.add(new Employee(null,"asd3","0","fad",0));
            employees.add(new Employee(null,"asd4","0","fad",1));
            mapper.addEmps(employees);
            openSession.commit();
        }finally {
            openSession.close();
        }
        return ":";
    }

    @RequestMapping("/test17s")
    @ResponseBody
    public List<Employee> MyBatisLastNameText17s() throws IOException {
        List<Employee> employee;
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            MyBatisDynamicSQL mapper = openSession.getMapper(MyBatisDynamicSQL.class);
            employee = mapper.getEmpTestInnerBind("c");
            openSession.commit();
        }finally {
            openSession.close();
        }
        return employee;
    }
}
