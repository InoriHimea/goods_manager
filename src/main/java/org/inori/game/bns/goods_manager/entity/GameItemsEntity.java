package org.inori.game.bns.goods_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "GameItems", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
public class GameItemsEntity {
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
    private int itemId;
    @Basic@Column(name = "GameItemKey")
    private String gameItemKey;
    @Basic@Column(name = "GameItemData")
    private String gameItemData;

    @JsonIgnore
    @OneToOne
    //@MapsId
    @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    private ItemsEntity item;
}
