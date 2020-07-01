package org.inori.game.bns.goods_manager.converter;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.enums.KeyValueEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;

//@Converter(autoApply = true)
@Slf4j
public abstract class KeyValueEnumConverter<E extends Enum<E> & KeyValueEnum<T>, T> implements
        AttributeConverter<KeyValueEnum<T>, T> {

    private Class<E> clazz;
    private Method valuesMethod;

    @SuppressWarnings("unchecked")
    public KeyValueEnumConverter() {
        this.clazz =
                (Class<E>) (((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments())[0];
        try {
            this.valuesMethod = clazz.getDeclaredMethod("values");
        } catch (NoSuchMethodException e) {
            log.error("获取方法失败", e);
            throw new RuntimeException("未找到实例对应的超类方法");
        }
    }

    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     *
     *
     * @param baseEnum the entity attribute value to be converted
     * @return the converted data to be stored in the database
     * column
     */
    @Override
    public T convertToDatabaseColumn(KeyValueEnum<T> baseEnum) {
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
    @SuppressWarnings("unchecked")
    @Override
    public KeyValueEnum<T> convertToEntityAttribute(T code) {
        log.debug("转换值到枚举");
        try {
            E[] e = (E[]) valuesMethod.invoke(null);
            return Arrays.stream(e)
                    .filter(c -> c.getKey() == code)
                    .findFirst()
                    .orElse(e[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error("参数异常", e);
            throw new RuntimeException("系统异常", e);
        }
    }
}
