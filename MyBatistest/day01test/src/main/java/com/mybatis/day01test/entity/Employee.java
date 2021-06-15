package com.mybatis.day01test.entity;

import lombok.Data;

@Data
public class Employee {

    private Integer id;
    private String last_name;
    private String gender;
    private String email;
}