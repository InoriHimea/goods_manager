package org.inori.game.bns.goods_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

/**
 * @author InoriHimea
 * @date 2020/6/18 14:08
 */
@Getter
@AllArgsConstructor
public enum PurchaseType implements KeyValueEnum<Short> {

    UNKNOWN_PURCHASE_TYPE_1((short) 1, "未知的物品购买类型1"),
    UNKNOWN_PURCHASE_TYPE_2((short) 2, "未知的物品购买类型2");

    private short key;
    private String value;

    @Override
    public Short getKey() {
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getValue();
    }

    @Converter(autoApply = true)
    public static class PurchaseTypeConverter extends KeyValueEnumConverter<PurchaseType, Short> {

    }
}
