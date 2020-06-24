package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsItems", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsItemsEntityPK.class)
public class GoodsItemsEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    private int goodsId;
    @Id@Column(name = "ItemId")
    private int itemId;
    @Basic@Column(name = "ItemQuantity")
    private int itemQuantity;
    @Basic@Column(name = "ItemExpirationType")
    private short itemExpirationType;
    @Basic@Column(name = "ItemExpireAt")
    private Date itemExpireAt = Date.from(
            LocalDateTime.of(2099, 12, 31, 23, 59, 59)
                    .atZone(ZoneId.systemDefault()).toInstant());
    @Basic@Column(name = "ItemExpirationDuration")
    private Integer itemExpirationDuration;
    @Basic@Column(name = "ItemData")
    private String itemData;
    @Basic@Column(name = "DeliveryPriority")
    private int deliveryPriority;
    @Basic@Column(name = "LimitedGameServerMask")
    private String limitedGameServerMask;
    private Boolean isSelectableItem;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsItemBasicPricesEntity.class)
    @JoinColumns({
            @JoinColumn(name = "GoodsId", insertable = false, updatable = false),
            @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    })
    private List<GoodsItemBasicPricesEntity> goodsItemBasicPrices;

    @Basic
    @Column(name = "IsSelectableItem")
    public Boolean getSelectableItem() {
        return isSelectableItem;
    }

    public void setSelectableItem(Boolean selectableItem) {
        isSelectableItem = selectableItem;
    }

}
