package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsItemBasicPrices", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsItemBasicPricesEntityPK.class)
@ApiModel("物品项目基础价格")
public class GoodsItemBasicPricesEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品ID")
    private int goodsId;
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
    @ApiModelProperty("项目ID")
    private int itemId;
    @Id@Column(name = "CurrencyGroupId")
    @ApiModelProperty("货币组ID")
    private short currencyGroupId = 71;
    @Basic@Column(name = "BasicSalePrice")
    @ApiModelProperty("基础售卖价格")
    private BigDecimal basicSalePrice = BigDecimal.ZERO;
    @Basic@Column(name = "BasicRefundPrice")
    @ApiModelProperty("基础退款价格")
    private BigDecimal basicRefundPrice;
    @Basic@Column(name = "BasicRefundPricePerSecond")
    @ApiModelProperty("基础退款价格/秒")
    private BigDecimal basicRefundPricePerSecond;
    @Basic@Column(name = "BasicRefundPricePerHour")
    @ApiModelProperty("基础退款价格/时")
    private BigDecimal basicRefundPricePerHour;
    @Basic@Column(name = "BasicRefundPricePerDay")
    @ApiModelProperty("基础退款价格/天")
    private BigDecimal basicRefundPricePerDay;

}
