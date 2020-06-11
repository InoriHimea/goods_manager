package org.inori.game.bns.goods_manager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.inori.game.bns.goods_manager.util.GoodItemKeyGenerator;

import javax.persistence.*;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "GameItems", schema = "dbo", catalog = "GoodsDb")
@DynamicInsert
@DynamicUpdate
public class GameItemsEntity {
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
    private int itemId = this.item.getItemId();
    @Basic@Column(name = "GameItemKey")
    @ApiModelProperty(hidden = true)
    private String gameItemKey = GoodItemKeyGenerator.generatorKey(itemId);
    @Basic@Column(name = "GameItemData")
    private String gameItemData = "AAAAAAAAAAA=";

    @JsonIgnore
    @OneToOne
    //@MapsId
    @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    @ApiModelProperty(hidden = true)
    private ItemsEntity item;
}
