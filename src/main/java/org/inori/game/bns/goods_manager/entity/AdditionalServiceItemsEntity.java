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
@Table(name = "AdditionalServiceItems", schema = "dbo", catalog = "GoodsDb")
@DynamicUpdate
@DynamicInsert
public class AdditionalServiceItemsEntity {
    @Id@Column(name = "ItemId", insertable = false, updatable = false)
    private int itemId;
    @Basic@Column(name = "AdditionalServiceType")
    private short additionalServiceType;

    @JsonIgnore
    @OneToOne
    //@MapsId
    @JoinColumn(name = "ItemId", insertable = false, updatable = false)
    @ApiModelProperty(hidden = true)
    private ItemsEntity item;
}
