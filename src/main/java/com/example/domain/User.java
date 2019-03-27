package com.example.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName User
 * @Description TODO
 * @Author hao
 * @Date 2019/3/22 11:43
 **/
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -5423067787593230604L;

    private String id;

    private String name;

    private Integer age;

}
