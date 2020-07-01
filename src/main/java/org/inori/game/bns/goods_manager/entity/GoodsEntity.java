package org.inori.game.bns.goods_manager.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.inori.game.bns.goods_manager.controller.model.Constant;
import org.inori.game.bns.goods_manager.enums.DeliveryType;
import org.inori.game.bns.goods_manager.enums.GoodType;
import org.inori.game.bns.goods_manager.enums.PurchaseType;
import org.inori.game.bns.goods_manager.enums.SaleStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    @ApiModelProperty(value = "物品ID，不能重复", required = true)
    private int goodsId;
    @Basic@Column(name = "GoodsName")
    @ApiModelProperty(value = "物品名称", required = true)
    private String goodsName;
    @Basic@Column(name = "GoodsAppGroupCode")
    private String goodsAppGroupCode = Constant.DEFAULT_APP_GROUP_CODE;
    @Basic@Column(name = "GoodsType")
    @Convert(converter = GoodType.GoodTypeConverter.class)
    private GoodType goodsType = GoodType.UNKNOWN_GOOD_TYPE_3;
    @Basic@Column(name = "DeliveryType")
    private DeliveryType deliveryType = DeliveryType.UNKNOWN_DELIVERY_1;
    @Basic@Column(name = "SaleStatus")
    @Convert(converter = SaleStatus.SaleStatusConverter.class)
    private SaleStatus saleStatus = SaleStatus.FOR_SALE;
    @Basic@Column(name = "EffectiveFrom")
    private Date effectiveFrom = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    @Basic@Column(name = "EffectiveTo")
    private Date effectiveTo = Date.from(
                                                            LocalDateTime.of(2099, 12, 31, 23, 59, 59)
                                                            .atZone(ZoneId.systemDefault()).toInstant()
                                                    );
    @Basic@Column(name = "SaleableQuantity")
    @ApiModelProperty("可销售的数量，默认0")
    private int saleableQuantity = 0;
    @Basic@Column(name = "RefundUnitCode")
    @ApiModelProperty("退款单位Code")
    private short refundUnitCode = 1;
    @ApiModelProperty("是否可退款")
    private boolean isRefundable = true;
    @ApiModelProperty("是否可以重复支付")
    private boolean isAvailableRecurringPayment = true;
    @Basic@Column(name = "Changed")
    @ApiModelProperty("修订时间")
    private Date changed = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    @Basic@Column(name = "ChangerAdminAccount")
    @ApiModelProperty("修订人")
    private String changerAdminAccount = Constant.DEFAULT_ACCOUNT_NAME;
    @Basic@Column(name = "GoodsDescription")
    @ApiModelProperty("物品描述")
    private String goodsDescription;
    @Basic@Column(name = "GoodsData")
    @ApiModelProperty(value = "物品数据", allowableValues = "AQAAAAM=,AAAAAAE=,AAACAAE=,AAAAAAI=,AQACAAE=,AAAAAAA=,AAABAAE=,AQAAAAE=,AQABAAE=,AAAAAAM=")
    private String goodsData = "AAACAAE=";
    @Basic@Column(name = "ParentGoodsId")
    @ApiModelProperty(value = "父物品ID")
    private Integer parentGoodsId;
    @Basic@Column(name = "GoodsPurchaseType")
    @ApiModelProperty("物品购买类型")
    private PurchaseType goodsPurchaseType = PurchaseType.UNKNOWN_PURCHASE_TYPE_1;
    @Basic@Column(name = "SelectableItemQuantity")
    @ApiModelProperty("可选项目数量")
    private Integer selectableItemQuantity;
    @Basic@Column(name = "GoodsPurchaseCheckMask")
    @ApiModelProperty("物品购买检查掩码")
    private Integer goodsPurchaseCheckMask = 4;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "parentGoodsId")
    @OrderBy("effectiveFrom asc")
    @ApiModelProperty("子节点，通过parentGoodsId关联")
    private List<GoodsEntity> childrenList;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsSaleLimitEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品销售限制")
    private List<GoodsSaleLimitEntity> goodsSaleLimit;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsCategoriesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品的分类")
    private List<GoodsCategoriesEntity> goodsCategory;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsDisplayEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品的显示")
    private List<GoodsDisplayEntity> goodsDisplay;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsAccountGradesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty(value = "物品账户等级？暂时未发现使用方法", hidden = true)
    private List<GoodsAccountGradesEntity> goodsAccountGrades;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsBasicPricesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品基础价格信息")
    private List<GoodsBasicPricesEntity> goodsBasicPrices;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsSalePricePoliciesEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品销售价格策略")
    private List<GoodsSalePricePoliciesEntity> goodsSalePricePolicies;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, targetEntity =
            GoodsItemsEntity.class)
    @JoinColumn(name = "GoodsId", insertable = false, updatable = false)
    @ApiModelProperty("物品项目列表")
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
