package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsDisplay", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsDisplayEntityPK.class)
public class GoodsDisplayEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    private int goodsId;
    @Id@Column(name = "LanguageCode")
    @Convert(converter = LanguageCode.LanguageCodeConverter.class)
    private LanguageCode languageCode;
    @Basic@Column(name = "GoodsDisplayName")
    private String goodsDisplayName;
    @Basic@Column(name = "GoodsDisplayDescription")
    private String goodsDisplayDescription;

}
