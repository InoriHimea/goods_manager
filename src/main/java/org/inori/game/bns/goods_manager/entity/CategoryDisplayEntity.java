package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CategoryDisplay", schema = "dbo", catalog = "GoodsDb")
@IdClass(CategoryDisplayEntityPK.class)
public class CategoryDisplayEntity {
    @Id@Column(name = "CategoryId")
    private short categoryId;
    @Id@Basic@Column(name = "LanguageCode")
    @Convert(converter = LanguageCodeConverter.class)
    private LanguageCode languageCode;
    @Basic@Column(name = "CategoryDisplayName")
    private String categoryDisplayName;
    @Basic@Column(name = "CategoryDisplayDescription")
    private String categoryDisplayDescription;
}
