package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_stock", schema = "leyou", catalog = "")
public class TbStock {
    private long skuId;
    private Integer seckillStock;
    private Integer seckillTotal;
    private int stock;

    @Id
    @Column(name = "sku_id")
    public long getSkuId() {
        return skuId;
    }

    public void setSkuId(long skuId) {
        this.skuId = skuId;
    }

    @Basic
    @Column(name = "seckill_stock")
    public Integer getSeckillStock() {
        return seckillStock;
    }

    public void setSeckillStock(Integer seckillStock) {
        this.seckillStock = seckillStock;
    }

    @Basic
    @Column(name = "seckill_total")
    public Integer getSeckillTotal() {
        return seckillTotal;
    }

    public void setSeckillTotal(Integer seckillTotal) {
        this.seckillTotal = seckillTotal;
    }

    @Basic
    @Column(name = "stock")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbStock tbStock = (TbStock) o;
        return skuId == tbStock.skuId &&
                stock == tbStock.stock &&
                Objects.equals(seckillStock, tbStock.seckillStock) &&
                Objects.equals(seckillTotal, tbStock.seckillTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skuId, seckillStock, seckillTotal, stock);
    }
}
