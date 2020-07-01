package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
@DynamicInsert
@DynamicUpdate
@ApiModel("物品项目")
public class GoodsItemsEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品ID")
    private int goodsId;
    @Id@Column(name = "ItemId")
    @ApiModelProperty("项目ID")
    private int itemId;
    @Basic@Column(name = "ItemQuantity")
    @ApiModelProperty("项目数量")
    private int itemQuantity;
    @Basic@Column(name = "ItemExpirationType")
    @ApiModelProperty("项目过期类型")
    private short itemExpirationType;
    @Basic@Column(name = "ItemExpireAt")
    @ApiModelProperty("过期时间，类型为Date的时候有效")
    private Date itemExpireAt = Date.from(
                                                            LocalDateTime.of(2099, 12, 31, 23, 59, 59)
                                                            .atZone(ZoneId.systemDefault()).toInstant()
                                                    );
    @Basic@Column(name = "ItemExpirationDuration")
    @ApiModelProperty("有效期，类型为Duration时有效，单位暂时认为按天算")
    private Integer itemExpirationDuration;
    @Basic@Column(name = "ItemData")
    @ApiModelProperty("数据，目前按默认值处理 -> AAAAAAEA")
    private String itemData = "AAAAAAEA";
    @Basic@Column(name = "DeliveryPriority")
    @ApiModelProperty("优先级，默认为1")
    private int deliveryPriority = 1;
    @Basic@Column(name = "LimitedGameServerMask")
    @ApiModelProperty("受限制的游戏服务器掩码")
    private String limitedGameServerMask;
    @ApiModelProperty("是否为可选项目")
    private Boolean isSelectableItem;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsItemBasicPricesEntity.class)
    @JoinColumns({
            @JoinColumn(name = "GoodsId", insertable = false, updatable = false),
            @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    })
    @ApiModelProperty("物品项目基础价格列表")
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
