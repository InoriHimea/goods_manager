package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsAccountGradesEntityPK implements Serializable {
    private int goodsId;
    private short accountGradeId;

    @Column(name = "GoodsId")
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "AccountGradeId")
    @Id
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
        GoodsAccountGradesEntityPK that = (GoodsAccountGradesEntityPK) o;
        return goodsId == that.goodsId &&
                accountGradeId == that.accountGradeId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, accountGradeId);
    }
}
