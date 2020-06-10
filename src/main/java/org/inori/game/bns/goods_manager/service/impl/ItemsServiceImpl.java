package org.inori.game.bns.goods_manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.ItemsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.model.SelectOption;
import org.inori.game.bns.goods_manager.repository.ItemsRepository;
import org.inori.game.bns.goods_manager.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ItemsServiceImpl implements ItemsService {

    @Autowired
    private ItemsRepository itemsRepository;

    @Override
    public List<SelectOption<Integer>> getItemsOptions() {
        List<ItemsEntity> itemsList = itemsRepository.findAll(Sort.by(Sort.Order.asc("itemId")));
        return itemsList.stream()
                .map(itemsEntity ->
                        SelectOption.<Integer>builder()
                                .key(itemsEntity.getItemId())
                                .value(itemsEntity.getItemName())
                                .build())
                .collect(Collectors.toList());
    }

    @Override
    public Page<ItemsEntity> findAll(int size, int no) {
        return itemsRepository.findAll(PageRequest.of(no - 1, size));
    }

    @Override
    public ItemsEntity save(ItemsEntity item) throws IDExistsException {
        if (itemsRepository.existsById(item.getItemId())) {
            throw new IDExistsException("需要保存的ID已存在，请更换或尝试更新");
        }
        return itemsRepository.saveAndFlush(item);
    }
}
