package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsBasicPrices", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsBasicPricesEntityPK.class)
public class GoodsBasicPricesEntity {
    @Id@Column(name = "GoodsId")
    private int goodsId;
    @Id@Column(name = "CurrencyGroupId")
    private short currencyGroupId;
    @Basic@Column(name = "BasicSalePrice")
    private BigDecimal basicSalePrice;
    @Basic@Column(name = "RefundFee")
    private BigDecimal refundFee;

}
