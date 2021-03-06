package org.inori.game.bns.goods_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

@Getter
@AllArgsConstructor
//@ToString
public enum GoodType implements KeyValueEnum<Integer> {


    UNKNOWN_GOOD_TYPE_3(3, "未知物品类型3"),
    UNKNOWN_GOOD_TYPE_7(7, "未知物品类型7");

    private int key;
    private String value;

    public Integer getKey() {
        return key;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getValue();
    }

    @Converter(autoApply = true)
    public static class GoodTypeConverter extends KeyValueEnumConverter<GoodType, Integer> {

    }
}
