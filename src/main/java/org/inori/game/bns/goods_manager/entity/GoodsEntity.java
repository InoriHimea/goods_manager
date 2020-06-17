package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.inori.game.bns.goods_manager.enums.GoodType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Goods", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
public class GoodsEntity {
    @Id@Column(name = "GoodsId")
    private int goodsId;
    @Basic@Column(name = "GoodsName")
    private String goodsName;
    @Basic@Column(name = "GoodsAppGroupCode")
    private String goodsAppGroupCode;
    @Basic@Column(name = "GoodsType")
    @Convert(converter = GoodType.GoodTypeConverter.class)
    private GoodType goodsType;
    @Basic@Column(name = "DeliveryType")
    private short deliveryType;
    @Basic@Column(name = "SaleStatus")
    private short saleStatus;
    @Basic@Column(name = "EffectiveFrom")
    private Date effectiveFrom;
    @Basic@Column(name = "EffectiveTo")
    private Date effectiveTo;
    @Basic@Column(name = "SaleableQuantity")
    private int saleableQuantity;
    @Basic@Column(name = "RefundUnitCode")
    private short refundUnitCode;
    private boolean isRefundable;
    private boolean isAvailableRecurringPayment;
    @Basic@Column(name = "Changed")
    private Date changed;
    @Basic@Column(name = "ChangerAdminAccount")
    private String changerAdminAccount;
    @Basic@Column(name = "GoodsDescription")
    private String goodsDescription;
    @Basic@Column(name = "GoodsData")
    private String goodsData;
    @Basic@Column(name = "ParentGoodsId")
    private Integer parentGoodsId;
    @Basic@Column(name = "GoodsPurchaseType")
    private short goodsPurchaseType;
    @Basic@Column(name = "SelectableItemQuantity")
    private Integer selectableItemQuantity;
    @Basic@Column(name = "GoodsPurchaseCheckMask")
    private Integer goodsPurchaseCheckMask;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsSaleLimitEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsSaleLimitEntity> goodsSaleLimit;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsCategoriesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsCategoriesEntity> goodsCategory;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsDisplayEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsDisplayEntity> goodsDisplay;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsAccountGradesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsAccountGradesEntity> goodsAccountGrades;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsBasicPricesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsBasicPricesEntity> goodsBasicPrices;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsSalePricePoliciesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsSalePricePoliciesEntity> goodsSalePricePolicies;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsItemsEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    private List<GoodsItemsEntity> goodsItems;

    @Basic
    @Column(name = "IsRefundable")
    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }

    @Basic
    @Column(name = "IsAvailableRecurringPayment")
    public boolean isAvailableRecurringPayment() {
        return isAvailableRecurringPayment;
    }

    public void setAvailableRecurringPayment(boolean availableRecurringPayment) {
        isAvailableRecurringPayment = availableRecurringPayment;
    }

}
