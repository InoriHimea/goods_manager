package org.inori.game.bns.goods_manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

@Getter
@AllArgsConstructor
//@ToString
public enum DeliveryType implements KeyValueEnum<Integer> {

    UNKNOWN_DELIVERY_1(1, "未知交付类型1"),
    UNKNOWN_DELIVERY_2(2, "未知交付类型2");

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
    public static class DeliveryTypeConverter extends KeyValueEnumConverter<DeliveryType, Integer> {

    }
}
