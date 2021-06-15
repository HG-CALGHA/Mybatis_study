package com.mybatisday02.properties.imi;


import com.mybatisday02.properties.emtity.Employee;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

public interface MyBatisInterface {

    public Employee getEmpById(Integer id);

    public Map<String,Object> getEmpByIdAndlastName(Integer id, String lastName);

    @MapKey("id")
    public Map<Integer,Employee> getEmpByLastName(String lastName);

    public boolean addEmp(Employee employee);

    public Employee getEmpAndDept(Integer id);

    public Employee getEmpByIdStep(Integer id);

    public void upDataEmp(Employee employee);

    public void deleteEmpById(Integer id);

    public List<Employee> getEmpByLastNameLike(String lastName);

    public List<Employee> getEmpByDeptId(Integer id);

    public Employee getEmpByIds(Integer id);
}
