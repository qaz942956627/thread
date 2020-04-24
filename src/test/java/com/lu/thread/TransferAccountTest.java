package com.lu.thread;

import com.lu.thread.config.ThreadPool;
import com.lu.thread.dao.AccountDao;
import com.lu.thread.entity.Account;
import com.lu.thread.service.Transfer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.math.BigDecimal;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class TransferAccountTest {

    @Autowired
    private Transfer transfer;

    @Autowired
    private AccountDao accountDao;



    @Test
    void test() throws InterruptedException {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = ThreadPool.getInstances();
        CountDownLatch cdl = new CountDownLatch(200);
        ThreadLocal<CountDownLatch> threadLocal = new ThreadLocal<>();
        threadLocal.set(cdl);
        for (int i = 0; i < 100; i++) {
            threadPoolTaskExecutor.execute(() -> {
                //System.out.println(Thread.currentThread().getName()+"xiaoMingToXiaoHong");
                xiaoMingToXiaoHong();
                cdl.countDown();
            });
        }
        for (int i = 0; i < 100; i++) {
            threadPoolTaskExecutor.execute(() -> {
                //System.out.println(Thread.currentThread().getName()+"xiaoQiangToXiaoHong");
                xiaoQiangToXiaoHong();
                cdl.countDown();
            });
        }
//        for (int i = 0; i < 300; i++) {
//            threadPoolTaskExecutor.execute(() -> {
//                System.out.println(Thread.currentThread().getName()+"xiaoHongAdd");
//                xiaoHongAdd();
//            });
//        }
        System.out.println("任务分配完毕!!!!!!!!");
        cdl.await(10, TimeUnit.SECONDS);
        System.out.println("方法执行完毕!!!!!!!!!!!");
        accountDao.findAll().forEach((account) -> {
            System.out.println(account.getUserName()+"账户余额:"+account.getMoney());
        });
        BigDecimal sumMoney = accountDao.findAll().stream().map(Account::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("总金额为:" + sumMoney);

    }

    @Test
    void reset() {
        transfer.reset();
        accountDao.findAll().forEach((account) -> {
            System.out.println(account.getUserName()+"账户余额:"+account.getMoney());
        });
    }

    private void xiaoMingToXiaoHong() {
        try {
            transfer.testTransfer(1L,2L);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private void xiaoQiangToXiaoHong() {
        try {
            transfer.testTransfer(3L,2L);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void xiaoHongAdd(){
        transfer.testDeposit(2L);
    }

}
