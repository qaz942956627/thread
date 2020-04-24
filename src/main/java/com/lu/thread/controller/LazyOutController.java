package com.lu.thread.controller;

import com.lu.thread.config.ThreadPool;
import com.lu.thread.service.LazyOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 小卢
 */
@RestController
public class LazyOutController {

    @Autowired
    private LazyOutput lazyOutput;


    @RequestMapping("out")
    public String LazyOut() {
        ThreadPoolTaskExecutor threadPool = ThreadPool.getInstances();
        for (int i = 0; i < 10; i++) {
            int tmp = i;
            threadPool.execute(() -> {
                try {
                    lazyOutput.output(tmp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        return "out程序结束";
    }

    @RequestMapping("out1")
    public String LazyOut1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            lazyOutput.output(1);
        }
        return "out1程序结束";
    }

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }

}
