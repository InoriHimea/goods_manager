package org.inori.game.bns.goods_manager.enums;

/**
 * @author InoriHimea
 * @date 2020/6/12 9:21
 */
public interface KeyValueEnum<T> {

    /**
     * 获取对应的key
     * @return 返回对应类型
     */
    T getKey();

    /**
     * 获取对应的值，值固定为String类型
     * @return
     */
    String getValue();
}
