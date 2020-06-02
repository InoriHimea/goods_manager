package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GoodsCategories", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsCategoriesEntityPK.class)
public class GoodsCategoriesEntity {
    private int goodsId;
    private short categoryId;
    private int displayOrder;

    @Id
    @Column(name = "GoodsId")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "CategoryId")
    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "DisplayOrder")
    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsCategoriesEntity that = (GoodsCategoriesEntity) o;
        return goodsId == that.goodsId &&
                categoryId == that.categoryId &&
                displayOrder == that.displayOrder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, categoryId, displayOrder);
    }
}
