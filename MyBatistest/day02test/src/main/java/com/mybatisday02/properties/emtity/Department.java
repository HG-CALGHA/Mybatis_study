package com.mybatisday02.properties.emtity;

import lombok.Data;

import java.util.List;

@Data
public class Department {
    private Integer did;
    private String departName;
    private List<Employee> emps;
}
