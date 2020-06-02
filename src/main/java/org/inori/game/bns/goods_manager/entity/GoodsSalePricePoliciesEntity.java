package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsSalePricePolicies", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsSalePricePoliciesEntityPK.class)
public class GoodsSalePricePoliciesEntity {
    @Id@Column(name = "GoodsId")
    private int goodsId;
    @Id@Column(name = "CurrencyGroupId")
    private short currencyGroupId;
    @Id@Column(name = "PricePolicyType")
    private short pricePolicyType;
    @Id@Column(name = "EffectiveFrom")
    private Date effectiveFrom;
    @Basic@Column(name = "EffectiveTo")
    private Date effectiveTo;
    @Basic@Column(name = "SalePrice")
    private BigDecimal salePrice;
    @Basic@Column(name = "DiscountValueType")
    private Short discountValueType;
    @Basic@Column(name = "DiscountValue")
    private BigDecimal discountValue;
    @Basic@Column(name = "DiscountKey")
    private String discountKey;
    @Basic@Column(name = "RewardValueType")
    private Short rewardValueType;
    @Basic@Column(name = "RewardValue")
    private BigDecimal rewardValue;
    @Basic@Column(name = "RewardTargetKey")
    private String rewardTargetKey;
    @Basic@Column(name = "RewardTargetKeyType")
    private Short rewardTargetKeyType;
    @Basic@Column(name = "GameGradeKey")
    private String gameGradeKey;

}
