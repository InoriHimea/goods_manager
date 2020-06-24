package org.inori.game.bns.goods_manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

@Getter
@AllArgsConstructor
//@ToString
public enum GoodType implements KeyValueEnum<Integer> {

    UNKNOWN_TYPE_1(1, "暂时未知翻译1");

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
    public static class GoodTypeConverter extends KeyValueEnumConverter<GoodType, Integer> {

    }
}
