package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GoodsDisplay", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsDisplayEntityPK.class)
public class GoodsDisplayEntity {
    private int goodsId;
    private short languageCode;
    private String goodsDisplayName;
    private String goodsDisplayDescription;

    @Id
    @Column(name = "GoodsId")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "LanguageCode")
    public short getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(short languageCode) {
        this.languageCode = languageCode;
    }

    @Basic
    @Column(name = "GoodsDisplayName")
    public String getGoodsDisplayName() {
        return goodsDisplayName;
    }

    public void setGoodsDisplayName(String goodsDisplayName) {
        this.goodsDisplayName = goodsDisplayName;
    }

    @Basic
    @Column(name = "GoodsDisplayDescription")
    public String getGoodsDisplayDescription() {
        return goodsDisplayDescription;
    }

    public void setGoodsDisplayDescription(String goodsDisplayDescription) {
        this.goodsDisplayDescription = goodsDisplayDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsDisplayEntity that = (GoodsDisplayEntity) o;
        return goodsId == that.goodsId &&
                languageCode == that.languageCode &&
                Objects.equals(goodsDisplayName, that.goodsDisplayName) &&
                Objects.equals(goodsDisplayDescription, that.goodsDisplayDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, languageCode, goodsDisplayName, goodsDisplayDescription);
    }
}
