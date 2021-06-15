package com.mybatisday02.properties.imi;

import com.mybatisday02.properties.emtity.Department;
import com.mybatisday02.properties.emtity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName MyBatisDynamicSQL
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/16 9:11
 * @Version 1.0
 */
public interface MyBatisDynamicSQL {


    public List<Employee> getEmpByConditionIf(Employee employee);
    public List<Employee> getEmpByConditionChoose(Employee employee);
    public void upDataEmpByCondition(Employee employee);
    public List<Employee> getEmpByConditionForeach(Employee employee);
    public List<Employee> departByIdSteps(List<Integer> ids);
    public void addEmps(@Param("emps")List<Employee> emps);
    public List<Employee> getEmpTestInnerBind(String lastName);


}
