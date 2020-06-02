package org.inori.game.bns.goods_manager.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum GoodsItem {
    UNKNOWN_TYPE_1(1, "暂时未知翻译1");

    private int key;
    private String value;
}
