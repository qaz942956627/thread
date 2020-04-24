package com.lu.thread.service;

import com.lu.thread.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @author 小卢
 */
@Service
public class LazyOutput {

    //@Async
    public void output(int i) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Thread.currentThread().getName());
        System.out.println(LocalDateTime.now());
    }

    @Qualifier("wang")
    @Autowired
    private Teacher teacher;

    public void souTeacher() {
        System.out.println(teacher);
    }
}
