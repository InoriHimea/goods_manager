package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ChargeItems", schema = "dbo", catalog = "GoodsDb")
public class ChargeItemsEntity {
    private int itemId;
    private short currencyId;

    @Id
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "CurrencyId")
    public short getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(short currencyId) {
        this.currencyId = currencyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChargeItemsEntity that = (ChargeItemsEntity) o;
        return itemId == that.itemId &&
                currencyId == that.currencyId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, currencyId);
    }
}
