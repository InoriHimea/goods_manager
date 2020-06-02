package org.inori.game.bns.goods_manager.converter;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.enums.LanguageCode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
@Slf4j
public class LanguageCodeConverter implements AttributeConverter<LanguageCode, Integer> {

    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param baseEnum the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public Integer convertToDatabaseColumn(LanguageCode baseEnum) {
        log.debug("枚举转换到值");
        return baseEnum.getKey();
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param code the data from the database column to be
     *               converted
     * @return the converted value to be stored in the entity
     * attribute
     */
    @Override
    public LanguageCode convertToEntityAttribute(Integer code) {
        log.debug("转换值到枚举");
        return Stream.of(LanguageCode.values())
                .filter(c -> c.getKey() == code)
                .findFirst()
                .orElse(LanguageCode.DEFAULT);
    }
}
