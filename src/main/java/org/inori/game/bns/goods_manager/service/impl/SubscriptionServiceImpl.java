package org.inori.game.bns.goods_manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.SubscriptionItemsEntity;
import org.inori.game.bns.goods_manager.repository.SubscriptionRepository;
import org.inori.game.bns.goods_manager.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SubscriptionServiceImpl implements SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Override
    public Page<SubscriptionItemsEntity> findAll(int size, int no) {
        return subscriptionRepository.findAll(PageRequest.of(no, size));
    }
}
