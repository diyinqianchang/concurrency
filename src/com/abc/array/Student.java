package com.abc.array;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Date 2025/7/31 21:07
 * @Version 1.0
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
