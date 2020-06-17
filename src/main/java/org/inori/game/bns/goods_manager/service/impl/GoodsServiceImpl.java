package org.inori.game.bns.goods_manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.GoodsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;
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

    @Override
    public GoodsEntity addOne(GoodsEntity good) throws IDExistsException {
        if (goodsRepository.existsById(good.getGoodsId())) {
            throw new IDExistsException("ID已存在，请更换或使用更新！");
        }
        return goodsRepository.saveAndFlush(good);
    }

    @Override
    public GoodsEntity updateOne(GoodsEntity good) throws IDNotExistsException {
        if (! goodsRepository.existsById(good.getGoodsId())) {
            throw new IDNotExistsException("ID不存在了，请创建");
        }
        return goodsRepository.saveAndFlush(good);
    }

    @Override
    public boolean deleteOne(int id) {
        goodsRepository.deleteById(id);
        return goodsRepository.existsById(id);
    }
}
