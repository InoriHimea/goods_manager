package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "CouponItems", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
public class CouponItemsEntity {
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
    private int itemId;
    @Basic@Column(name = "IssueId")
    private int issueId;
}
