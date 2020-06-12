package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
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
    @Id@Column(name = "CategoryId", updatable = false)
    @ApiModelProperty(value = "分类的ID", required = true)
    private short categoryId;
    /*@Id*/@Basic@Column(name = "LanguageCode")
    @Convert(converter = LanguageCode.LanguageCodeConverter.class)
    @ApiModelProperty(value = "语言Code", required = true)
    private LanguageCode languageCode = LanguageCode.THAI;
    @Basic@Column(name = "CategoryDisplayName")
    @ApiModelProperty(value="分类显示名称", required = true)
    private String categoryDisplayName;
    @Basic@Column(name = "CategoryDisplayDescription")
    @ApiModelProperty(value = "分类显示描述")
    private String categoryDisplayDescription;
}
