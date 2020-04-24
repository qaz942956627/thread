package com.lu.thread.dao;

import com.lu.thread.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<Users,Long> ,JpaSpecificationExecutor<Users> {
}
