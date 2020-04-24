package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_category_brand", schema = "leyou", catalog = "")
@IdClass(TbCategoryBrandPK.class)
public class TbCategoryBrand {
    private long categoryId;
    private long brandId;

    @Id
    @Column(name = "category_id")
    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    @Id
    @Column(name = "brand_id")
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
        TbCategoryBrand that = (TbCategoryBrand) o;
        return categoryId == that.categoryId &&
                brandId == that.brandId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, brandId);
    }
}
