package com.lu.thread.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "tb_sku", schema = "leyou", catalog = "")
public class TbSku {
    private long id;
    private long spuId;
    private String title;
    private String images;
    private long price;
    private String indexes;
    private String ownSpec;
    private byte enable;
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
    @Column(name = "spu_id")
    public long getSpuId() {
        return spuId;
    }

    public void setSpuId(long spuId) {
        this.spuId = spuId;
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
    @Column(name = "images")
    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Basic
    @Column(name = "price")
    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Basic
    @Column(name = "indexes")
    public String getIndexes() {
        return indexes;
    }

    public void setIndexes(String indexes) {
        this.indexes = indexes;
    }

    @Basic
    @Column(name = "own_spec")
    public String getOwnSpec() {
        return ownSpec;
    }

    public void setOwnSpec(String ownSpec) {
        this.ownSpec = ownSpec;
    }

    @Basic
    @Column(name = "enable")
    public byte getEnable() {
        return enable;
    }

    public void setEnable(byte enable) {
        this.enable = enable;
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
        TbSku tbSku = (TbSku) o;
        return id == tbSku.id &&
                spuId == tbSku.spuId &&
                price == tbSku.price &&
                enable == tbSku.enable &&
                Objects.equals(title, tbSku.title) &&
                Objects.equals(images, tbSku.images) &&
                Objects.equals(indexes, tbSku.indexes) &&
                Objects.equals(ownSpec, tbSku.ownSpec) &&
                Objects.equals(createTime, tbSku.createTime) &&
                Objects.equals(lastUpdateTime, tbSku.lastUpdateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, spuId, title, images, price, indexes, ownSpec, enable, createTime, lastUpdateTime);
    }
}
