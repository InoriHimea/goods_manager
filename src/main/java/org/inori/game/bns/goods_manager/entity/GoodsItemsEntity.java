package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsItems", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsItemsEntityPK.class)
public class GoodsItemsEntity {
    @Id@Column(name = "GoodsId")
    private int goodsId;
    @Id@Column(name = "ItemId")
    private int itemId;
    @Basic@Column(name = "ItemQuantity")
    private int itemQuantity;
    @Basic@Column(name = "ItemExpirationType")
    private short itemExpirationType;
    @Basic@Column(name = "ItemExpireAt")
    private Date itemExpireAt;
    @Basic@Column(name = "ItemExpirationDuration")
    private Integer itemExpirationDuration;
    @Basic@Column(name = "ItemData")
    private String itemData;
    @Basic@Column(name = "DeliveryPriority")
    private int deliveryPriority;
    @Basic@Column(name = "LimitedGameServerMask")
    private String limitedGameServerMask;
    private Boolean isSelectableItem;

    @Basic
    @Column(name = "IsSelectableItem")
    public Boolean getSelectableItem() {
        return isSelectableItem;
    }

    public void setSelectableItem(Boolean selectableItem) {
        isSelectableItem = selectableItem;
    }

}
