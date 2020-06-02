package org.inori.game.bns.goods_manager.service;

import org.inori.game.bns.goods_manager.entity.SubscriptionItemsEntity;
import org.springframework.data.domain.Page;

public interface SubscriptionService {

    Page<SubscriptionItemsEntity> findAll(int size, int no);
}
