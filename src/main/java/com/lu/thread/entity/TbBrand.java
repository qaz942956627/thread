package com.lu.thread.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_brand", schema = "leyou", catalog = "")
public class TbBrand {
    private long id;
    private String name;
    private String image;
    private String letter;

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
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "letter")
    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbBrand tbBrand = (TbBrand) o;
        return id == tbBrand.id &&
                Objects.equals(name, tbBrand.name) &&
                Objects.equals(image, tbBrand.image) &&
                Objects.equals(letter, tbBrand.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, image, letter);
    }
}
