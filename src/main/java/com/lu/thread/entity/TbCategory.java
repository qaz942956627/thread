package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_category", schema = "leyou", catalog = "")
public class TbCategory {
    private long id;
    private String name;
    private long parentId;
    private byte isParent;
    private int sort;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "parent_id")
    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "is_parent")
    public byte getIsParent() {
        return isParent;
    }

    public void setIsParent(byte isParent) {
        this.isParent = isParent;
    }

    @Basic
    @Column(name = "sort")
    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCategory that = (TbCategory) o;
        return id == that.id &&
                parentId == that.parentId &&
                isParent == that.isParent &&
                sort == that.sort &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, parentId, isParent, sort);
    }
}
