package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@EqualsAndHashCode
@Data
public class GoodsAccountGradesEntityPK implements Serializable {
    @Column(name = "GoodsId")@Id
    private int goodsId;
    @Column(name = "AccountGradeId")@Id
    private short accountGradeId;

}
