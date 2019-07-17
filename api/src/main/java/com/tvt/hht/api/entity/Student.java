package com.tvt.hht.api.entity;

import java.io.Serializable;

/**
 * @author hht
 * @date 2019/7/17 10:48
 * @description
 */
public class Student implements Serializable {

    private static final long serialVersionUID = -2946568290066547483L;
    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

}
