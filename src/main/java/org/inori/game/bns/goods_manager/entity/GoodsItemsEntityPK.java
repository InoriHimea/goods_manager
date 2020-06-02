package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsItemsEntityPK implements Serializable {
    private int goodsId;
    private int itemId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsItemsEntityPK that = (GoodsItemsEntityPK) o;
        return goodsId == that.goodsId &&
                itemId == that.itemId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, itemId);
    }
}
