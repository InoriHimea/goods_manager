package org.inori.game.bns.goods_manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

/**
 * @author InoriHimea
 * @date 2020/6/17 19:47
 */
@Getter
@AllArgsConstructor
public enum SaleLimitType implements KeyValueEnum<Integer> {

    ;

    private int key;
    private String value;

    public Integer getKey() {
        return key;
    }

    @Converter(autoApply = true)
    public static class SaleLimitTypeConverter extends KeyValueEnumConverter<SaleLimitType, Integer> {

    }
}
