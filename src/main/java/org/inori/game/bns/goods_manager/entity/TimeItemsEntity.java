package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "TimeItems", schema = "dbo", catalog = "GoodsDb")
public class TimeItemsEntity {
    @Id@Column(name = "ItemId")
    private int itemId;
    @Basic@Column(name = "DeductionStartType")
    private short deductionStartType;
    @Basic@Column(name = "TimeItemType")
    private short timeItemType;
    @Basic@Column(name = "DeductionUnitType")
    private short deductionUnitType;
    @Basic@Column(name = "EffectiveDurationUnitType")
    private short effectiveDurationUnitType;
    @Basic@Column(name = "EffectiveDuration")
    private int effectiveDuration;
    @Basic@Column(name = "ChargeTimePerSecond")
    private int chargeTimePerSecond;
    @Basic@Column(name = "EffectiveTimeMask")
    private String effectiveTimeMask;
    @Basic@Column(name = "DiscountTimeMask")
    private String discountTimeMask;
    @Basic@Column(name = "BasicPricePerSecond")
    private BigDecimal basicPricePerSecond;
    @Basic@Column(name = "BasicPricePerHour")
    private BigDecimal basicPricePerHour;
    @Basic@Column(name = "BasicPricePerDay")
    private BigDecimal basicPricePerDay;
    @Basic@Column(name = "BasicPricePerMinute")
    private BigDecimal basicPricePerMinute;
    @Basic@Column(name = "BasicPriceMask")
    private BigDecimal basicPriceMask;

}
