package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class GoodsSalePricePoliciesEntityPK implements Serializable {
    @Column(name = "GoodsId")@Id
    private int goodsId;
    @Column(name = "CurrencyGroupId")@Id
    private short currencyGroupId;
    @Column(name = "PricePolicyType")@Id
    private short pricePolicyType;
    @Column(name = "EffectiveFrom")@Id
    private Date effectiveFrom;

}
