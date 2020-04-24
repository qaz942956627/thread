package com.lu.thread;

import com.lu.thread.config.ThreadPool;
import com.lu.thread.service.Transfer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class TransferAccountTest {

    @Autowired
    private Transfer transfer;



    @Test
    void test() throws InterruptedException {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = ThreadPool.getInstances();
        CountDownLatch cdl = new CountDownLatch(600);
        for (int i = 0; i < 300; i++) {
            threadPoolTaskExecutor.execute(() -> {
                cdl.countDown();
                System.out.println(Thread.currentThread().getName()+"xiaoMingToXiaoHong");
                xiaoMingToXiaoHong();
            });
        }
        for (int i = 0; i < 300; i++) {
            threadPoolTaskExecutor.execute(() -> {
                cdl.countDown();
                System.out.println(Thread.currentThread().getName()+"xiaoQiangToXiaoHong");
                xiaoQiangToXiaoHong();
            });
        }
//        for (int i = 0; i < 300; i++) {
//            threadPoolTaskExecutor.execute(() -> {
//                System.out.println(Thread.currentThread().getName()+"xiaoHongAdd");
//                xiaoHongAdd();
//            });
//        }
        cdl.await(10, TimeUnit.SECONDS);
        System.out.println("方法执行完毕!!!!!!!!!!!");

    }

    @Test
    void reset() {
        transfer.reset();
    }

    private void xiaoMingToXiaoHong() {
        transfer.testTransfer(1L,2L);
    }

    private void xiaoQiangToXiaoHong() {
        transfer.testTransfer(3L,2L);
    }

    private void xiaoHongAdd(){
        transfer.testDeposit(2L);
    }

}
