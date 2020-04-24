package com.lu.thread.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TbCategoryBrandPK implements Serializable {
    private long categoryId;
    private long brandId;

    @Column(name = "category_id")
    @Id
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Column(name = "brand_id")
    @Id
    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCategoryBrandPK that = (TbCategoryBrandPK) o;
        return categoryId == that.categoryId &&
                brandId == that.brandId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, brandId);
    }
}
