package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsItemBasicPrices", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsItemBasicPricesEntityPK.class)
public class GoodsItemBasicPricesEntity {
    @Id@Column(name = "GoodsId")
    private int goodsId;
    @Id@Column(name = "ItemId")
    private int itemId;
    @Id@Column(name = "CurrencyGroupId")
    private short currencyGroupId;
    @Basic@Column(name = "BasicSalePrice")
    private BigDecimal basicSalePrice;
    @Basic@Column(name = "BasicRefundPrice")
    private BigDecimal basicRefundPrice;
    @Basic@Column(name = "BasicRefundPricePerSecond")
    private BigDecimal basicRefundPricePerSecond;
    @Basic@Column(name = "BasicRefundPricePerHour")
    private BigDecimal basicRefundPricePerHour;
    @Basic@Column(name = "BasicRefundPricePerDay")
    private BigDecimal basicRefundPricePerDay;

}
