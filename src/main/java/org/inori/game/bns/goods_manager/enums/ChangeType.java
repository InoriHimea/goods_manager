package org.inori.game.bns.goods_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

/**
 * @author InoriHimea
 * @date 2020/6/18 10:58
 */
@Getter
@AllArgsConstructor
public enum ChangeType implements KeyValueEnum<Integer> {

    UNKNOWN_CHANGE_TYPE_1(1, "未知修改类型1");

    private int key;
    private String value;

    @Override
    public Integer getKey() {
        return key;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getValue();
    }

    @Converter(autoApply = true)
    public static class ChangeTypeConverter extends KeyValueEnumConverter<ChangeType, Integer> {

    }
}
