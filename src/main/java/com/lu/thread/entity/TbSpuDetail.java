package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_spu_detail", schema = "leyou", catalog = "")
public class TbSpuDetail {
    private long spuId;
    private String description;
    private String genericSpec;
    private String specialSpec;
    private String packingList;
    private String afterService;

    @Id
    @Column(name = "spu_id")
    public long getSpuId() {
        return spuId;
    }

    public void setSpuId(long spuId) {
        this.spuId = spuId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "generic_spec")
    public String getGenericSpec() {
        return genericSpec;
    }

    public void setGenericSpec(String genericSpec) {
        this.genericSpec = genericSpec;
    }

    @Basic
    @Column(name = "special_spec")
    public String getSpecialSpec() {
        return specialSpec;
    }

    public void setSpecialSpec(String specialSpec) {
        this.specialSpec = specialSpec;
    }

    @Basic
    @Column(name = "packing_list")
    public String getPackingList() {
        return packingList;
    }

    public void setPackingList(String packingList) {
        this.packingList = packingList;
    }

    @Basic
    @Column(name = "after_service")
    public String getAfterService() {
        return afterService;
    }

    public void setAfterService(String afterService) {
        this.afterService = afterService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbSpuDetail that = (TbSpuDetail) o;
        return spuId == that.spuId &&
                Objects.equals(description, that.description) &&
                Objects.equals(genericSpec, that.genericSpec) &&
                Objects.equals(specialSpec, that.specialSpec) &&
                Objects.equals(packingList, that.packingList) &&
                Objects.equals(afterService, that.afterService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(spuId, description, genericSpec, specialSpec, packingList, afterService);
    }
}
