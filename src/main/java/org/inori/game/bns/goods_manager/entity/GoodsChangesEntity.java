package org.inori.game.bns.goods_manager.entity;

import lombok.*;
import org.inori.game.bns.goods_manager.controller.model.Constant;
import org.inori.game.bns.goods_manager.enums.ChangeType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
    @Convert(converter = ChangeType.ChangeTypeConverter.class)
    private ChangeType changeType = ChangeType.UNKNOWN_CHANGE_TYPE_1;
    @Basic@Column(name = "Registered")
    private Date registered = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    @Basic@Column(name = "RegistrarAdminAccount")
    private String registrarAdminAccount = Constant.DEFAULT_ACCOUNT_NAME;
    @Basic@Column(name = "ChangeDescription")
    private String changeDescription;
    @Basic@Column(name = "GoodsAppGroupCode")
    private String goodsAppGroupCode = Constant.DEFAULT_APP_GROUP_CODE;
    private Boolean isDisplayable = true;

    @Basic
    @Column(name = "IsDisplayable")
    public Boolean getDisplayable() {
        return isDisplayable;
    }

    public void setDisplayable(Boolean displayable) {
        isDisplayable = displayable;
    }

}
