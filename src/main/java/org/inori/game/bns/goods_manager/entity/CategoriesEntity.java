package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static javax.persistence.ConstraintMode.CONSTRAINT;

@Data
@Builder
@Entity
@Table(name = "Categories", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
public class CategoriesEntity {
    @Tolerate
    public CategoriesEntity(){}

    @Id@Column(name = "CategoryId")
    private short categoryId;
    @Basic@Column(name = "CategoryName")
    private String categoryName;
    @Basic@Column(name = "AppGroupCode")
    private String appGroupCode = "bnsgrnTH";
    private boolean isDisplayable;
    @Basic@Column(name = "DisplayOrder")
    private int displayOrder;
    @Basic@Column(name = "Changed")
    private Date changed;
    @Basic@Column(name = "ChangerAdminAccount")
    private String changerAdminAccount = "GoodsManagerUser";
    @Basic@Column(name = "CurrencyGroupId")
    private Short currencyGroupId = 71;
    @Basic@Column(name = "ParentCategoryId")
    private Short parentCategoryId;
    @Basic@Column(name = "CategoryData")
    private String categoryData = "{\"CategoryType\":[\"01\"]}";
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentCategoryId")
    @OrderBy("displayOrder asc")
    private List<CategoriesEntity> children;
    @OneToMany(/*mappedBy = "categoryId",*/ cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity = CategoryDisplayEntity.class)
    @JoinColumns(value = {
            @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
/*            @JoinColumn(name = "languageCode", referencedColumnName = "categoryId")*/
    }, foreignKey = @ForeignKey(CONSTRAINT))
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
