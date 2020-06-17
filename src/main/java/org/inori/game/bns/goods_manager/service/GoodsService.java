package org.inori.game.bns.goods_manager.service;

import org.inori.game.bns.goods_manager.entity.GoodsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;
import org.springframework.data.domain.Page;

/**
 * @author InoriHimea
 * @date 2020/6/8 20:10
 */
public interface GoodsService {

    Page<GoodsEntity> findAll(int size, int no);

    GoodsEntity addOne(GoodsEntity good) throws IDExistsException;

    GoodsEntity updateOne(GoodsEntity good) throws IDNotExistsException;

    boolean deleteOne(int id);
}
