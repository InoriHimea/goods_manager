package org.inori.game.bns.goods_manager.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "GoodsChanges", schema = "dbo", catalog = "GoodsDb")
public class GoodsChangesEntity {
    @Id@Column(name = "GoodsChangeId")
    private int goodsChangeId;
    @Basic@Column(name = "ChangeId")
    private int changeId;
    @Basic@Column(name = "ChangeType")
    private short changeType;
    @Basic@Column(name = "Registered")
    private Date registered;
    @Basic@Column(name = "RegistrarAdminAccount")
    private String registrarAdminAccount;
    @Basic@Column(name = "ChangeDescription")
    private String changeDescription;
    @Basic@Column(name = "GoodsAppGroupCode")
    private String goodsAppGroupCode;
    private Boolean isDisplayable;

    @Basic
    @Column(name = "IsDisplayable")
    public Boolean getDisplayable() {
        return isDisplayable;
    }

    public void setDisplayable(Boolean displayable) {
        isDisplayable = displayable;
    }

}
