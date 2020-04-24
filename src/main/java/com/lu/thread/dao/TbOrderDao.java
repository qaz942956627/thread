package com.lu.thread.dao;

import com.lu.thread.entity.TbOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TbOrderDao extends JpaRepository<TbOrder,Long> ,JpaSpecificationExecutor<TbOrder> {
}
