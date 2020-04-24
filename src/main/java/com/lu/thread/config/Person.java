package com.lu.thread.config;

import com.lu.thread.entity.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Hashtable;

/**
 * @author 小卢
 */

@Configuration
public class Person {


    @Bean(name = "li")
    public Teacher teacher() {
        Teacher teacher = new Teacher();
        teacher.setName("教师");
        teacher.setAge(34);

        return teacher;
    }


    @Bean(name = "wang")
    public Teacher teacher1() {
        Teacher teacher = new Teacher();
        teacher.setName("王老师");
        teacher.setAge(18);

        return teacher;
    }





}
