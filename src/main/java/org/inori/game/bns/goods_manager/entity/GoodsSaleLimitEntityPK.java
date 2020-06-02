package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsSaleLimitEntityPK implements Serializable {
    private int goodsId;
    private short saleLimitType;

    @Column(name = "GoodsId")
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "SaleLimitType")
    @Id
    public short getSaleLimitType() {
        return saleLimitType;
    }

    public void setSaleLimitType(short saleLimitType) {
        this.saleLimitType = saleLimitType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsSaleLimitEntityPK that = (GoodsSaleLimitEntityPK) o;
        return goodsId == that.goodsId &&
                saleLimitType == that.saleLimitType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, saleLimitType);
    }
}
