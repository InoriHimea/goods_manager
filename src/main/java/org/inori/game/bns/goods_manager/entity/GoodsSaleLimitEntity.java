package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GoodsSaleLimit", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsSaleLimitEntityPK.class)
public class GoodsSaleLimitEntity {
    private int goodsId;
    private short saleLimitType;
    private int saleLimitValue;
    private String saleLimitExternalKey;

    @Id
    @Column(name = "GoodsId")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "SaleLimitType")
    public short getSaleLimitType() {
        return saleLimitType;
    }

    public void setSaleLimitType(short saleLimitType) {
        this.saleLimitType = saleLimitType;
    }

    @Basic
    @Column(name = "SaleLimitValue")
    public int getSaleLimitValue() {
        return saleLimitValue;
    }

    public void setSaleLimitValue(int saleLimitValue) {
        this.saleLimitValue = saleLimitValue;
    }

    @Basic
    @Column(name = "SaleLimitExternalKey")
    public String getSaleLimitExternalKey() {
        return saleLimitExternalKey;
    }

    public void setSaleLimitExternalKey(String saleLimitExternalKey) {
        this.saleLimitExternalKey = saleLimitExternalKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsSaleLimitEntity that = (GoodsSaleLimitEntity) o;
        return goodsId == that.goodsId &&
                saleLimitType == that.saleLimitType &&
                saleLimitValue == that.saleLimitValue &&
                Objects.equals(saleLimitExternalKey, that.saleLimitExternalKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, saleLimitType, saleLimitValue, saleLimitExternalKey);
    }
}
