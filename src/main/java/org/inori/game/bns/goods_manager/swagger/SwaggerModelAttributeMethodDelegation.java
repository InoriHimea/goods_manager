package org.inori.game.bns.goods_manager.swagger;

import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author InoriHimea
 * @date 2020/6/10 15:29
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SwaggerModelAttributeMethodDelegation {

    //@Advice.OnMethodExit
    public static Set<PropertyDescriptor> propertyDescriptors(final Class<?> clazz) {
        log.debug("列：{}", clazz);
        return Arrays.stream(clazz.getDeclaredFields())
                .filter(field -> {
                    ApiModelProperty apiModelProperty = field.getDeclaredAnnotation(ApiModelProperty.class);
                    if (apiModelProperty != null && apiModelProperty.hidden()) {
                        return false;
                    }
                    return true;
                })
                .map(field -> {
                    try {
                        String fieldName = field.getName();
                        String readMethodName = fieldName.startsWith("is") ? fieldName :
                                "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
                        String writeMethodName = "set" + (fieldName.startsWith("is") ? fieldName.substring(2) :
                                fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                        return new PropertyDescriptor(fieldName, clazz, readMethodName, writeMethodName);
                    } catch (IntrospectionException e) {
                        log.warn(String.format("Failed to get bean properties on (%s)", clazz), e);
                    }
                    return null;
                })
                .collect(Collectors.toSet());
    }
}
