package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsAccountGrades", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsAccountGradesEntityPK.class)
public class GoodsAccountGradesEntity {
    @Id@Column(name = "GoodsId", insertable = false, updatable = false)
    private int goodsId;
    @Id@Column(name = "AccountGradeId")
    private short accountGradeId;

}
