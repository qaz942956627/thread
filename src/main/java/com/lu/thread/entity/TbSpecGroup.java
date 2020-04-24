package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_spec_group", schema = "leyou", catalog = "")
public class TbSpecGroup {
    private long id;
    private long cid;
    private String name;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "cid")
    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSpecGroup that = (TbSpecGroup) o;
        return id == that.id &&
                cid == that.cid &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cid, name);
    }
}
