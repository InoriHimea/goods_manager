package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "AdditionalServiceItems", schema = "dbo", catalog = "GoodsDb")
public class AdditionalServiceItemsEntity {
    @Id@Column(name = "ItemId")
    private int itemId;
    @Basic@Column(name = "AdditionalServiceType")
    private short additionalServiceType;

}
