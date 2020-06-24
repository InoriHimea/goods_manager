package org.inori.game.bns.goods_manager.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.inori.game.bns.goods_manager.converter.KeyValueEnumConverter;

import javax.persistence.Converter;

@Getter
@AllArgsConstructor
//@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum LanguageCode implements KeyValueEnum<Integer> {

    DEFAULT(0, "默认语言"),
    KOREAN(1, "韩语"),
    ENGLISH(2, "英语"),
    JAPANESE(3, "日语"),
    CHINESE_S(4, "简中"),
    CHINESE_T(5, "繁中"),
    RUSSIAN(6, "俄语"),
    FRENCH(7, "法语"),
    GERMAN(8, "德语"),
    //UNKNOWN_1(9, "未知1"),
    //UNKNOWN_2(10, "未知2"),
    THAI(11, "泰语"),
    VIETNAMESE(12, "越南语");

    private int key;
    private String value;

    public Integer getKey() {
        return key;
    }

    @JsonValue
    @Override
    public String toString() {
        //return this.getValue();
        return this.getValue();
    }

    @Converter(autoApply = true)
    public static class LanguageCodeConverter extends KeyValueEnumConverter<LanguageCode, Integer> {

    }
}
