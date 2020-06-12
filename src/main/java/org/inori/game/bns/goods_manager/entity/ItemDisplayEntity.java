package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ItemDisplay", schema = "dbo", catalog = "GoodsDb")
@IdClass(ItemDisplayEntityPK.class)
@DynamicInsert
@DynamicUpdate
public class ItemDisplayEntity {
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
    private int itemId;
    @Basic@Column(name = "LanguageCode")
    @Convert(converter = LanguageCode.LanguageCodeConverter.class)
    private LanguageCode languageCode = LanguageCode.THAI;
    @Basic@Column(name = "ItemDisplayName")
    private String itemDisplayName;
    @Basic@Column(name = "ItemDisplayDescription")
    private String itemDisplayDescription;

}
