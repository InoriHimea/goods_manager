package org.inori.game.bns.goods_manager.repository;

import org.inori.game.bns.goods_manager.entity.SubscriptionItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<SubscriptionItemsEntity, Integer> {

}
