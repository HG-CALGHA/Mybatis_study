package com.mybatis03.cache.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

/**
 * @ClassName Employee
 * @Description TODO
 * @Author CGH
 * @Date 2020/12/17 19:59
 * @Version 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private Integer id;
    private String lastName;
    private String gender;
    private String email;
    private Integer d_id;

}
