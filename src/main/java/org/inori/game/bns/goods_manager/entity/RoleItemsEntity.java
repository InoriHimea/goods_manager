package org.inori.game.bns.goods_manager.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "RoleItems", schema = "dbo", catalog = "GoodsDb")
public class RoleItemsEntity {
    private int itemId;
    private int itemAppGroupId;
    private short roleId;

    @Id
    @Column(name = "ItemId")
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "ItemAppGroupId")
    public int getItemAppGroupId() {
        return itemAppGroupId;
    }

    public void setItemAppGroupId(int itemAppGroupId) {
        this.itemAppGroupId = itemAppGroupId;
    }

    @Basic
    @Column(name = "RoleId")
    public short getRoleId() {
        return roleId;
    }

    public void setRoleId(short roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleItemsEntity that = (RoleItemsEntity) o;
        return itemId == that.itemId &&
                itemAppGroupId == that.itemAppGroupId &&
                roleId == that.roleId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, itemAppGroupId, roleId);
    }
}
