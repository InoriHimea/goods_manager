package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDisplayEntityPK implements Serializable {
    @Column(name = "CategoryId")@Id
    private short categoryId;
    /*@Id*/@Basic@Column(name = "LanguageCode")
    @Convert(converter = LanguageCodeConverter.class)
    private LanguageCode languageCode;
}
