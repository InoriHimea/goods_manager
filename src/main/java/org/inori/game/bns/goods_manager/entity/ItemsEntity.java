package org.inori.game.bns.goods_manager.entity;

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

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = ItemDisplayEntity.class)
    @JoinColumn(name = "itemId")
    private List<ItemDisplayEntity> itemDisplay;

    @Basic
    @Column(name = "IsConsumable")
    public boolean isConsumable() {
        return isConsumable;
    }

    public void setConsumable(boolean consumable) {
        isConsumable = consumable;
    }

}
