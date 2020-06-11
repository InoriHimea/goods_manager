package org.inori.game.bns.goods_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "TimeItems", schema = "dbo", catalog = "GoodsDb")
@DynamicUpdate
@DynamicInsert
public class TimeItemsEntity {
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
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

    @JsonIgnore
    @OneToOne
    //@MapsId
    @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    @ApiModelProperty(hidden = true)
    private ItemsEntity item;
}
