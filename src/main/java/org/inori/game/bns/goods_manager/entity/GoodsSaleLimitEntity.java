package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty("物品ID")
    private int goodsId;
    @Basic@Column(name = "SaleLimitType")
    @Convert(converter = SaleLimitType.SaleLimitTypeConverter.class)
    @ApiModelProperty("贩售类型")
    private SaleLimitType saleLimitType;
    @Basic@Column(name = "SaleLimitValue")
    @ApiModelProperty("限制值")
    private int saleLimitValue;
    @Basic@Column(name = "SaleLimitExternalKey")
    @ApiModelProperty("销售限制的额外Key")
    private String saleLimitExternalKey;

}
