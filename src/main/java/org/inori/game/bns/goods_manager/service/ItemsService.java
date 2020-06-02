package org.inori.game.bns.goods_manager.service;

import org.inori.game.bns.goods_manager.model.SelectOption;

import java.util.List;

public interface ItemsService {

    List<SelectOption<Integer>> getItemsOptions();
}
