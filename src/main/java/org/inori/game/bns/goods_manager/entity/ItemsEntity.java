package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.inori.game.bns.goods_manager.controller.model.Constant;
import org.inori.game.bns.goods_manager.enums.ItemType;

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
    @ApiModelProperty(value = "物品ID", allowableValues = "range[0, 10000]", required = true)
    private int itemId;
    @Basic@Column(name = "ItemName")
    @ApiModelProperty(value = "物品名称", position = 1, required = true)
    private String itemName;
    @Basic@Column(name = "ItemAppGroupCode")
    @ApiModelProperty(value = "物品App组Code", position = 2, example = "bnsgrnTH")
    private String itemAppGroupCode = "bnsgrnTH";
    @Basic@Column(name = "ItemType")
    @ApiModelProperty(value = "物品类型", position = 3, example = "GAME_ITEM")
    @Convert(converter = ItemType.ItemTypeEnumConverter.class)
    private ItemType itemType = ItemType.GAME_ITEM;
    @ApiModelProperty(value = "是否为消耗品", position = 4)
    private boolean isConsumable = false;
    @Basic@Column(name = "BasicPrice")
    @ApiModelProperty(value = "基础价格", position = 5, example = "0")
    private BigDecimal basicPrice = BigDecimal.ZERO;
    @Basic@Column(name = "BasicCurrencyGroupId")
    @ApiModelProperty(value = "基础货币组ID", position = 6, example = "71")
    private short basicCurrencyGroupId = 71;
    @Basic@Column(name = "Changed")
    @ApiModelProperty(value = "更改时间", position = 7, example = "2017-02-13 00:15:07.000")
    private Date changed = new Date();
    @Basic@Column(name = "ChangerAdminAccount")
    @ApiModelProperty(value = "更改人账号", position = 8)
    private String changerAdminAccount = Constant.DEFAULT_ACCOUNT_NAME;
    @Basic@Column(name = "ItemDescription")
    @ApiModelProperty(value = "物品的描述", position = 9)
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
