package com.lu.thread.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author 小卢
 */
public class ThreadPool {

    private static ThreadPoolTaskExecutor THREAD_POOL_TASK_EXECUTOR = null;

    public ThreadPool() {
    }

    public synchronized static ThreadPoolTaskExecutor getInstances() {
        if (THREAD_POOL_TASK_EXECUTOR == null) {
            synchronized (ThreadPool.class) {
                if (THREAD_POOL_TASK_EXECUTOR == null) {
                    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
                    executor.setCorePoolSize(5);
                    executor.setMaxPoolSize(10);
                    executor.setQueueCapacity(999);
                    executor.setThreadNamePrefix("thread-pool");
                    //executor.setThreadGroupName("Group1");
                    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
                    executor.initialize();
                    THREAD_POOL_TASK_EXECUTOR = executor;
                }
            }
        }
        return THREAD_POOL_TASK_EXECUTOR;
    }


}
