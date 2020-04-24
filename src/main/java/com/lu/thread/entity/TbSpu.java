package com.lu.thread.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_spu", schema = "leyou", catalog = "")
public class TbSpu {
    private long id;
    private String title;
    private String subTitle;
    private long cid1;
    private long cid2;
    private long cid3;
    private long brandId;
    private byte saleable;
    private byte valid;
    private Timestamp createTime;
    private Timestamp lastUpdateTime;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "sub_title")
    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Basic
    @Column(name = "cid1")
    public long getCid1() {
        return cid1;
    }

    public void setCid1(long cid1) {
        this.cid1 = cid1;
    }

    @Basic
    @Column(name = "cid2")
    public long getCid2() {
        return cid2;
    }

    public void setCid2(long cid2) {
        this.cid2 = cid2;
    }

    @Basic
    @Column(name = "cid3")
    public long getCid3() {
        return cid3;
    }

    public void setCid3(long cid3) {
        this.cid3 = cid3;
    }

    @Basic
    @Column(name = "brand_id")
    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    @Basic
    @Column(name = "saleable")
    public byte getSaleable() {
        return saleable;
    }

    public void setSaleable(byte saleable) {
        this.saleable = saleable;
    }

    @Basic
    @Column(name = "valid")
    public byte getValid() {
        return valid;
    }

    public void setValid(byte valid) {
        this.valid = valid;
    }

    @Basic
    @Column(name = "create_time")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "last_update_time")
    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSpu tbSpu = (TbSpu) o;
        return id == tbSpu.id &&
                cid1 == tbSpu.cid1 &&
                cid2 == tbSpu.cid2 &&
                cid3 == tbSpu.cid3 &&
                brandId == tbSpu.brandId &&
                saleable == tbSpu.saleable &&
                valid == tbSpu.valid &&
                Objects.equals(title, tbSpu.title) &&
                Objects.equals(subTitle, tbSpu.subTitle) &&
                Objects.equals(createTime, tbSpu.createTime) &&
                Objects.equals(lastUpdateTime, tbSpu.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, subTitle, cid1, cid2, cid3, brandId, saleable, valid, createTime, lastUpdateTime);
    }
}
