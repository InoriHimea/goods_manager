package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "ItemDisplay", schema = "dbo", catalog = "GoodsDb")
@IdClass(ItemDisplayEntityPK.class)
public class ItemDisplayEntity {
    @Id@Column(name = "ItemId")
    private int itemId;
    @Id@Column(name = "LanguageCode")
    private LanguageCode languageCode = LanguageCode.THAI;
    @Basic@Column(name = "ItemDisplayName")
    private String itemDisplayName;
    @Basic@Column(name = "ItemDisplayDescription")
    private String itemDisplayDescription;

}
