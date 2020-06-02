package org.inori.game.bns.goods_manager.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class GoodsDisplayEntityPK implements Serializable {
    private int goodsId;
    private short languageCode;

    @Column(name = "GoodsId")
    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column(name = "LanguageCode")
    @Id
    public short getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(short languageCode) {
        this.languageCode = languageCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsDisplayEntityPK that = (GoodsDisplayEntityPK) o;
        return goodsId == that.goodsId &&
                languageCode == that.languageCode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, languageCode);
    }
}
