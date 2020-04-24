package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_spec_param", schema = "leyou", catalog = "")
public class TbSpecParam {
    private long id;
    private long cid;
    private long groupId;
    private String name;
    private byte numeric;
    private String unit;
    private byte generic;
    private byte searching;
    private String segments;

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
    @Column(name = "group_id")
    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
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
    @Column(name = "numeric")
    public byte getNumeric() {
        return numeric;
    }

    public void setNumeric(byte numeric) {
        this.numeric = numeric;
    }

    @Basic
    @Column(name = "unit")
    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Basic
    @Column(name = "generic")
    public byte getGeneric() {
        return generic;
    }

    public void setGeneric(byte generic) {
        this.generic = generic;
    }

    @Basic
    @Column(name = "searching")
    public byte getSearching() {
        return searching;
    }

    public void setSearching(byte searching) {
        this.searching = searching;
    }

    @Basic
    @Column(name = "segments")
    public String getSegments() {
        return segments;
    }

    public void setSegments(String segments) {
        this.segments = segments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSpecParam that = (TbSpecParam) o;
        return id == that.id &&
                cid == that.cid &&
                groupId == that.groupId &&
                numeric == that.numeric &&
                generic == that.generic &&
                searching == that.searching &&
                Objects.equals(name, that.name) &&
                Objects.equals(unit, that.unit) &&
                Objects.equals(segments, that.segments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cid, groupId, name, numeric, unit, generic, searching, segments);
    }
}
