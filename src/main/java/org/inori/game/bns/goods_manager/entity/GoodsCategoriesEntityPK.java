package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsCategoriesEntityPK implements Serializable {
    private int goodsId;
    private short categoryId;

    @Column(name = "GoodsId")
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "CategoryId")
    @Id
    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsCategoriesEntityPK that = (GoodsCategoriesEntityPK) o;
        return goodsId == that.goodsId &&
                categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, categoryId);
    }
}
