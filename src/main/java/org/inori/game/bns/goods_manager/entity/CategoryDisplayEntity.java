package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "CategoryDisplay", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
@IdClass(CategoryDisplayEntityPK.class)
@ApiModel("分类不同语言的显示")
public class CategoryDisplayEntity {
    @Id@Column(name = "CategoryId")
    private short categoryId;
    /*@Id*/@Basic@Column(name = "LanguageCode")
    @Convert(converter = LanguageCodeConverter.class)
    private LanguageCode languageCode;
    @Basic@Column(name = "CategoryDisplayName")
    private String categoryDisplayName;
    @Basic@Column(name = "CategoryDisplayDescription")
    private String categoryDisplayDescription;
}
