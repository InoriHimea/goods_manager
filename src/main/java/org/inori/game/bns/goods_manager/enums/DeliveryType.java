package org.inori.game.bns.goods_manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum DeliveryType {

    UNKNOWN_DELIVERY_1(1, "未知传送类型1"),
    UNKNOWN_DELIVERY_2(2, "未知传送类型2");

    private int key;
    private String value;
}
