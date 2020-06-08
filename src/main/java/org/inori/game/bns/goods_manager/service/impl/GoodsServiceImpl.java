package org.inori.game.bns.goods_manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.GoodsEntity;
import org.inori.game.bns.goods_manager.repository.GoodsRepository;
import org.inori.game.bns.goods_manager.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author InoriHimea
 * @date 2020/6/8 20:12
 */
@Service
@Slf4j
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    public Page<GoodsEntity> findAll(int size, int no) {
        return goodsRepository.findAll(PageRequest.of(no, size));
    }
}
