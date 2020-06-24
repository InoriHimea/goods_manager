package org.inori.game.bns.goods_manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

@Getter
@AllArgsConstructor
//@ToString
public enum ItemType implements KeyValueEnum<Integer> {

    CHARGE_ITEM(1, "付费商品"),
    TIME_ITEM(2, "时限商品"),
    GAME_ITEM(3, "游戏商品"),
    ADDITIONAL_SERVICE_ITEM(4, "条件服务类商品"),
    COUPON_ITEM(11, "券类商品"),
    GRADE_ITEM(12, "分级商品"),
    TAG_ITEM(13, "暂无翻译"),
    IN_GAME_COUPON_ITEM(14, "游戏内置券类商品"),
    LICENSE_ITEM(15, "许可类商品"),
    ROLE_ITEM(16, "角色商品"),
    GA_CHA_CHARGE_ITEM(17, "扭蛋付费商品"),
    GRADE_SCORE_ITEM(18, "积分商品"),
    UNKNOWN_ITEM_1(19, "未知商品1");

    private int key;
    private String value;

    public Integer getKey() {
        return key;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    @Converter(autoApply = true)
    public static class ItemTypeEnumConverter extends KeyValueEnumConverter<ItemType, Integer> {

    }
}
