package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CouponItems", schema = "dbo", catalog = "GoodsDb")
public class CouponItemsEntity {
    private int itemId;
    private int issueId;

    @Id
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "IssueId")
    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CouponItemsEntity that = (CouponItemsEntity) o;
        return itemId == that.itemId &&
                issueId == that.issueId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, issueId);
    }
}
