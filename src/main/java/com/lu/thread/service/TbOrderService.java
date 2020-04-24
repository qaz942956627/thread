package com.lu.thread.service;

import com.lu.thread.dao.TbOrderDao;
import com.lu.thread.entity.TbOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 小卢
 */
@Service
public class TbOrderService {

    @Autowired
    private TbOrderDao tbOrderDao;

    public List<TbOrder> findAll() {
        return tbOrderDao.findAll();
    }

    public TbOrder findOneById(Long id) {
        Optional<TbOrder> byId = tbOrderDao.findById(id);
        return byId.get();
    }

    public TbOrder save(TbOrder tbOrder) {
        return tbOrderDao.save(tbOrder);
    }
}
