package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemDisplayEntityPK implements Serializable {
    @Column(name = "ItemId")@Id
    private int itemId;
    @Column(name = "LanguageCode")@Basic
    @Convert(converter = LanguageCodeConverter.class)
    private LanguageCode languageCode;

}
