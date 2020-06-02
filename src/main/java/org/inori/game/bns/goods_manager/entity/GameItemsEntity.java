package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GameItems", schema = "dbo", catalog = "GoodsDb")
public class GameItemsEntity {
    private int itemId;
    private String gameItemKey;
    private String gameItemData;

    @Id
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "GameItemKey")
    public String getGameItemKey() {
        return gameItemKey;
    }

    public void setGameItemKey(String gameItemKey) {
        this.gameItemKey = gameItemKey;
    }

    @Basic
    @Column(name = "GameItemData")
    public String getGameItemData() {
        return gameItemData;
    }

    public void setGameItemData(String gameItemData) {
        this.gameItemData = gameItemData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameItemsEntity that = (GameItemsEntity) o;
        return itemId == that.itemId &&
                Objects.equals(gameItemKey, that.gameItemKey) &&
                Objects.equals(gameItemData, that.gameItemData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, gameItemKey, gameItemData);
    }
}
