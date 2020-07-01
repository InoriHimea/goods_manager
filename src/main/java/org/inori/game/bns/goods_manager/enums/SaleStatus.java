package org.inori.game.bns.goods_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

/**
 * @author InoriHimea
 * @date 2020/6/18 11:17
 */
@Getter
@AllArgsConstructor
public enum SaleStatus implements KeyValueEnum<Short> {

    NOT_FOR_SALE((short) 1, "不出售"),
    FOR_SALE((short) 2, "出售");

    private short key;
    private String value;

    @Override
    public Short getKey() {
        return key;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.getValue();
    }

    @Converter(autoApply = true)
    public static class SaleStatusConverter extends KeyValueEnumConverter<SaleStatus, Short> {

    }
}
