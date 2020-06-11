package org.inori.game.bns.goods_manager.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.*;
import org.inori.game.bns.goods_manager.controller.model.Constant;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categories", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
@ApiModel("商城分类")
public class CategoriesEntity {

    @Id@Column(name = "CategoryId", updatable = false)
    @ApiModelProperty(value = "分类的ID", required = true)
    private short categoryId;
    @Basic@Column(name = "CategoryName")
    @ApiModelProperty(value = "分类的名称", required = true)
    private String categoryName;
    @Basic@Column(name = "AppGroupCode", updatable = false)
    @ApiModelProperty(value = "App组Code", hidden = true)
    private String appGroupCode = "bnsgrnTH";
    @ApiModelProperty("是否显示")
    private boolean isDisplayable = true;
    @Basic@Column(name = "DisplayOrder")
    @ApiModelProperty("显示序号")
    private int displayOrder = 1;
    @Basic@Column(name = "Changed")
    @ApiModelProperty(value = "更改时间", hidden = true)
    private Date changed = new Date();
    @Basic@Column(name = "ChangerAdminAccount")
    @ApiModelProperty(value = "更改人账户", hidden = true)
    private String changerAdminAccount = Constant.DEFAULT_ACCOUNT_NAME;
    @Basic@Column(name = "CurrencyGroupId")
    @ApiModelProperty("货币组ID")
    private Short currencyGroupId = 71;
    @Basic@Column(name = "ParentCategoryId")
    @ApiModelProperty(value = "父分类ID", required = true)
    private Short parentCategoryId;
    @Basic@Column(name = "CategoryData")
    @ApiModelProperty(value = "分类数据")
    private String categoryData = "{\"CategoryType\":[\"01\"]}";
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentCategoryId")
    @OrderBy("displayOrder asc")
    @ApiModelProperty("子节点")
    private List<CategoriesEntity> children;
    @Fetch (FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, targetEntity = CategoryDisplayEntity.class)
    @ApiModelProperty("显示配置")
    private List<CategoryDisplayEntity> displayList;

    @Basic
    @Column(name = "IsDisplayable")
    public boolean isDisplayable() {
        return isDisplayable;
    }

    public void setDisplayable(boolean displayable) {
        isDisplayable = displayable;
    }

}
