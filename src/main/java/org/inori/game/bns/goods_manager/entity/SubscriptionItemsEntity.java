package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "SubscriptionItems", schema = "dbo", catalog = "GoodsDb")
public class SubscriptionItemsEntity {
    @Id@Column(name = "ItemId")
    private int itemId;
    @Basic@Column(name = "DeductionStartType")
    private Short deductionStartType;
    @Basic@Column(name = "DeductionUnitType")
    private Short deductionUnitType;
    @Basic@Column(name = "EffectiveDurationUnitType")
    private Short effectiveDurationUnitType;
    @Basic@Column(name = "EffectiveDuration")
    private Integer effectiveDuration;
    @Basic@Column(name = "BasicPricePerSecond")
    private BigDecimal basicPricePerSecond;
    @Basic@Column(name = "BasicPricePerHour")
    private BigDecimal basicPricePerHour;
    @Basic@Column(name = "BasicPricePerDay")
    private BigDecimal basicPricePerDay;
    @Basic@Column(name = "SubscriptionItemKey")
    private String subscriptionItemKey;
    @Basic@Column(name = "SubscriptionScore")
    private Integer subscriptionScore;
    @Basic@Column(name = "GameGradeKey")
    private String gameGradeKey;

}
