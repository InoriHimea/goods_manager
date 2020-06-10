package org.inori.game.bns.goods_manager.service;

import org.inori.game.bns.goods_manager.entity.ItemsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.model.SelectOption;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ItemsService {

    List<SelectOption<Integer>> getItemsOptions();

    Page<ItemsEntity> findAll(int size, int no);

    ItemsEntity save(ItemsEntity item) throws IDExistsException;
}
