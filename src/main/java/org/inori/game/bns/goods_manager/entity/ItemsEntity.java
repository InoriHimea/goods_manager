package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "Items", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
public class ItemsEntity {
    @Id@Column(name = "ItemId")
    private int itemId;
    @Basic@Column(name = "ItemName")
    private String itemName;
    @Basic@Column(name = "ItemAppGroupCode")
    private String itemAppGroupCode;
    @Basic@Column(name = "ItemType")
    private short itemType;
    private boolean isConsumable;
    @Basic@Column(name = "BasicPrice")
    private BigDecimal basicPrice;
    @Basic@Column(name = "BasicCurrencyGroupId")
    private short basicCurrencyGroupId;
    @Basic@Column(name = "Changed")
    private Date changed;
    @Basic@Column(name = "ChangerAdminAccount")
    private String changerAdminAccount;
    @Basic@Column(name = "ItemDescription")
    private String itemDescription;

    @MapsId
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            ItemDisplayEntity.class)
    @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    private List<ItemDisplayEntity> itemDisplay;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    //@JoinColumn(name = "itemId", insertable = false, updatable = false)
    private ChargeItemsEntity chargeItem;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    //@JoinColumn(name = "itemId", insertable = false, updatable = false)
    private TimeItemsEntity timeItem;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    //@JoinColumn(name = "itemId", insertable = false, updatable = false)
    private GameItemsEntity gameItem;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    //@JoinColumn(name = "itemId", insertable = false, updatable = false)
    private AdditionalServiceItemsEntity additionalServiceItem;

    @Basic
    @Column(name = "IsConsumable")
    public boolean isConsumable() {
        return isConsumable;
    }

    public void setConsumable(boolean consumable) {
        isConsumable = consumable;
    }

}
