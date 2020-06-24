package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsCategories", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsCategoriesEntityPK.class)
public class GoodsCategoriesEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    private int goodsId;
    @Id@Column(name = "CategoryId")
    private short categoryId;
    @Basic@Column(name = "DisplayOrder")
    private int displayOrder;

}
