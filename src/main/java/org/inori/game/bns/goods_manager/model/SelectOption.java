package org.inori.game.bns.goods_manager.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SelectOption<T> {

    private T key;
    private String value;
}
