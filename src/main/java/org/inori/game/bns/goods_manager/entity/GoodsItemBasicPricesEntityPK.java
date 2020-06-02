package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsItemBasicPricesEntityPK implements Serializable {
    private int goodsId;
    private int itemId;
    private short currencyGroupId;

    @Column(name = "GoodsId")
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "ItemId")
    @Id
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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
        GoodsItemBasicPricesEntityPK that = (GoodsItemBasicPricesEntityPK) o;
        return goodsId == that.goodsId &&
                itemId == that.itemId &&
                currencyGroupId == that.currencyGroupId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, itemId, currencyGroupId);
    }
}
