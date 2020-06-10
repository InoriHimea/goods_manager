package org.inori.game.bns.goods_manager.swagger;

import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.spring.web.readers.parameter.ModelAttributeParameterExpander;
import sun.reflect.misc.FieldUtil;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptySet;

/**
 * @author InoriHimea
 * @date 2020/6/10 15:29
 */
public class ModelAttributeCanIgnoreParameterExpander {

    private static final Logger LOG = LoggerFactory.getLogger(ModelAttributeCanIgnoreParameterExpander.class);

    private Set<PropertyDescriptor> propertyDescriptors(final Class<?> clazz) {
        try {
            return new HashSet<>(Arrays.stream(getBeanInfo(clazz).getPropertyDescriptors())
                    .filter(propertyDescriptor -> {
                        try {
                            Field field = FieldUtil.getField(clazz, propertyDescriptor.getName());
                            ApiModelProperty apiModelProperty = field.getDeclaredAnnotation(ApiModelProperty.class);

                            if (apiModelProperty != null && apiModelProperty.hidden()) {
                                return false;
                            }
                        } catch (NoSuchFieldException e) {
                            LOG.error("字段错误", e);
                            return false;
                        }

                        return true;
                    }).collect(Collectors.toList()));
        } catch (IntrospectionException e) {
            LOG.warn(String.format("Failed to get bean properties on (%s)", clazz), e);
        }
        return emptySet();
    }

    BeanInfo getBeanInfo(Class<?> clazz) throws IntrospectionException {
        return Introspector.getBeanInfo(clazz);
    }
}
