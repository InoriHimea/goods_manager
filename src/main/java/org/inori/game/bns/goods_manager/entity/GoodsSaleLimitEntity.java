package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.enums.SaleLimitType;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsSaleLimit", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsSaleLimitEntityPK.class)
public class GoodsSaleLimitEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    private int goodsId;
    @Basic@Column(name = "SaleLimitType")
    @Convert(converter = SaleLimitType.SaleLimitTypeConverter.class)
    private SaleLimitType saleLimitType;
    @Basic@Column(name = "SaleLimitValue")
    private int saleLimitValue;
    @Basic@Column(name = "SaleLimitExternalKey")
    private String saleLimitExternalKey;

}
