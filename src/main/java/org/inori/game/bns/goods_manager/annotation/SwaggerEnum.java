package org.inori.game.bns.goods_manager.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author InoriHimea
 * @date 2020/6/12 16:51
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SwaggerEnum {

    /**
     * key的字段名字
     * @return
     */
    String keyName() default "key";

    /**
     * value的字段名字
     * @return
     */
    String valueName() default "value";
}
