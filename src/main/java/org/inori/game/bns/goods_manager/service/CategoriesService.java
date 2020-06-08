package org.inori.game.bns.goods_manager.service;

import org.inori.game.bns.goods_manager.entity.CategoriesEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;

import java.util.List;

public interface CategoriesService {

    List<CategoriesEntity> findByParentCategoryId(Short id);

    CategoriesEntity save(CategoriesEntity category) throws IDExistsException;

    CategoriesEntity update(CategoriesEntity category) throws IDNotExistsException;

    Boolean delete(Short id);
}
