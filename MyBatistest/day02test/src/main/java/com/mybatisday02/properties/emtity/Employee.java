package com.mybatisday02.properties.emtity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String gender;
    private String email;
    private Integer d_id;

//    private Department department;

}
