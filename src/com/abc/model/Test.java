package com.abc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2025/9/20 14:29
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        Student student1 = new Student("张三", 18);
        Student student2 = new Student("张三", 19);

//        System.out.println(student1==student2);
//        System.out.println(student1.equals(student2));

        List<Student> students = new ArrayList<>();
        students.add(student2);
        students.add(student1);
        System.out.println(students);
        Collections.sort(students);
        System.out.println(students);

    }

}
