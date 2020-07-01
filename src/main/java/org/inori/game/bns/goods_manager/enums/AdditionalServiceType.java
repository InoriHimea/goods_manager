package org.inori.game.bns.goods_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

/**
 * @author InoriHimea
 * @date 2020/6/18 9:41
 */
@Getter
@AllArgsConstructor
public enum AdditionalServiceType implements KeyValueEnum<Integer> {

    UNKNOWN_ADDITIONAL_SERVICE_TYPE_1(1, "未知的条件服务类型");

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
    public static class AdditionalServiceTypeConverter extends KeyValueEnumConverter<AdditionalServiceType, Integer> {

    }
}
