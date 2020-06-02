package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsBasicPricesEntityPK implements Serializable {
    private int goodsId;
    private short currencyGroupId;

    @Column(name = "GoodsId")
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "CurrencyGroupId")
    @Id
    public short getCurrencyGroupId() {
        return currencyGroupId;
    }

    public void setCurrencyGroupId(short currencyGroupId) {
        this.currencyGroupId = currencyGroupId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsBasicPricesEntityPK that = (GoodsBasicPricesEntityPK) o;
        return goodsId == that.goodsId &&
                currencyGroupId == that.currencyGroupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, currencyGroupId);
    }
}
