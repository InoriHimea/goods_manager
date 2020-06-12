package org.inori.game.bns.goods_manager.converter;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.enums.KeyValueEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author InoriHimea
 * @date 2020/6/12 16:15
 */
@Slf4j
public class EnumConverterFactory implements ConverterFactory<String, KeyValueEnum<Integer>> {

    private static final Map<Class<?>, Converter<String, ?>> CONVERTER_MAP = new LinkedHashMap<>();

    /**
     * Get the converter to convert from S to target type T, where T is also an instance of R.
     *
     * @param targetType the target type to convert to
     * @return a converter from S to T
     */
    @SuppressWarnings("unchecked")
    public <T extends KeyValueEnum<Integer>> Converter<String, T> getConverter(Class<T> targetType) {
        log.debug("查询转换器：{}", targetType.getName());
        return (Converter<String, T>) CONVERTER_MAP.computeIfAbsent(targetType, k -> new EnumConverter<T>(targetType));
    }

    private static class EnumConverter<T extends KeyValueEnum<Integer>> implements Converter<String, T> {

        private final Map<String, T> enumsMap = new LinkedHashMap<>();

        EnumConverter(Class<T> targetType)  {
            Arrays.stream(targetType.getEnumConstants())
                    .forEach(action -> enumsMap.put(action.getValue(), action));
        }

        /**
         * Convert the source object of type {@code S} to target type {@code T}.
         *
         * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
         * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
         * @throws IllegalArgumentException if the source cannot be converted to the desired target type
         */
        @Override
        public T convert(String source) {
            log.debug("查询[{}]的值", source);
            return enumsMap.get(source);
        }
    }
}
