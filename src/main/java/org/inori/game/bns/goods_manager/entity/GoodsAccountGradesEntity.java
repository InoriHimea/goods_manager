package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GoodsAccountGrades", schema = "dbo", catalog = "GoodsDb")
@IdClass(GoodsAccountGradesEntityPK.class)
public class GoodsAccountGradesEntity {
    private int goodsId;
    private short accountGradeId;

    @Id
    @Column(name = "GoodsId")
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Id
    @Column(name = "AccountGradeId")
    public short getAccountGradeId() {
        return accountGradeId;
    }

    public void setAccountGradeId(short accountGradeId) {
        this.accountGradeId = accountGradeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsAccountGradesEntity that = (GoodsAccountGradesEntity) o;
        return goodsId == that.goodsId &&
                accountGradeId == that.accountGradeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, accountGradeId);
    }
}
