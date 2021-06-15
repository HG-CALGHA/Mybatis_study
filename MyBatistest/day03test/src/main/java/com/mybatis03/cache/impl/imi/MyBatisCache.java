package com.mybatis03.cache.impl.imi;

import com.mybatis03.cache.entity.Employee;

import java.util.List;

/**
 * @ClassName MyBatisCache
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/17 20:02
 * @Version 1.0
 */
public interface MyBatisCache {

    public List<Employee> getEmpById(Integer id);
    public void addEmp(Employee employee);

}
