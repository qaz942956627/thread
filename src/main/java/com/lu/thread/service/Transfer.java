package com.lu.thread.service;

import com.lu.thread.dao.AccountDao;
import com.lu.thread.dao.UserDao;
import com.lu.thread.entity.Account;
import com.lu.thread.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

/**
 * @author 小卢
 */
@Service
public class Transfer {

    @Autowired
    private UserDao userDao;

    @Autowired
    private AccountDao accountDao;

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();


    /**
     * 转账10元
     */
    @Transactional(rollbackOn = Exception.class)
    public void testTransfer(Long idFrom, Long idTo) {
        readWriteLock.writeLock().lock();
        try {

            //SQL语句 ： select * from users where id=？
            Optional<Users> byId = userDao.findById(idFrom);
            Users from = byId.get();
            Account fromAccount = accountDao.findAccountByUserId(from.getUserId());
            Optional<Users> byId1 = userDao.findById(idTo);
            Users to = byId1.get();
            Account toAccount = accountDao.findAccountByUserId(to.getUserId());

            System.out.println(Thread.currentThread().getName() + "------>" + from.getUserName() + "向" + to.getUserName() + "转账开始");

            delay(10L);
            //转账方减10元
            BigDecimal money = fromAccount.getMoney();
            BigDecimal tenYuan = new BigDecimal(10);
            BigDecimal newMoney = money.subtract(tenYuan);
            fromAccount.setMoney(newMoney);
            accountDao.save(fromAccount);

            //这里加上10毫秒的延时，用于测试
            delay(10L);

            //收款方增加10元
            BigDecimal toMoney = toAccount.getMoney();
            BigDecimal add = toMoney.add(tenYuan);
            toAccount.setMoney(add);
            accountDao.save(toAccount);
            System.out.println(Thread.currentThread().getName() + "------>" + from.getUserName() + "向" + to.getUserName() + "转账完毕---");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    /**
     * 存入1元
     *
     * @param id
     */
    @Transactional(rollbackOn = Exception.class)
    public void testDeposit(Long id) {

        readWriteLock.writeLock().lock();
        try {
            //System.out.println("小红自己存钱");
            Optional<Users> byId = userDao.findById(id);
            Users user = byId.get();
            Account account = accountDao.findAccountByUserId(user.getUserId());

            //延时10ms
            delay(3L);
            //存入1元
            BigDecimal money = account.getMoney();
            BigDecimal add = money.add(new BigDecimal(1));

            account.setMoney(add);
            accountDao.save(account);
            //System.out.println("小红自己存钱 完毕+++");
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void reset() {
        Account xiaoming = accountDao.getOne(1L);
        BigDecimal bigDecimal = new BigDecimal(10000);
        xiaoming.setMoney(bigDecimal);
        accountDao.save(xiaoming);
        Account xiaohong = accountDao.getOne(2L);
        xiaohong.setMoney(new BigDecimal(0));
        accountDao.save(xiaohong);
        Account xiaoqiang = accountDao.getOne(3L);
        xiaoqiang.setMoney(bigDecimal);
        accountDao.save(xiaoqiang);
    }


    /**
     * 延时
     */
    public void delay(Long ms) {
        try {
            TimeUnit.MILLISECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
