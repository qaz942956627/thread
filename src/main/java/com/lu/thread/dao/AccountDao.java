package com.lu.thread.dao;

import com.lu.thread.entity.Account;
import com.lu.thread.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 小卢
 */
public interface AccountDao extends JpaRepository<Account,Long> ,JpaSpecificationExecutor<Account> {

    /**
     * 根据用户id查询账户
     * @param userId
     * @return
     */
    Account findAccountByUserId(Long userId);

}
