package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
public class ItemDisplayEntityPK implements Serializable {
    @Column(name = "ItemId")@Id
    private int itemId;
    @Column(name = "LanguageCode")@Id
    private LanguageCode languageCode;

}
