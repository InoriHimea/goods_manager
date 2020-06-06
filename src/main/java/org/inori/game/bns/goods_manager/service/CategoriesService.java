package org.inori.game.bns.goods_manager.service;

import org.inori.game.bns.goods_manager.entity.CategoriesEntity;

import java.util.List;

public interface CategoriesService {

    List<CategoriesEntity> findByParentCategoryId(Short id);

    CategoriesEntity save(CategoriesEntity category);

    CategoriesEntity update(CategoriesEntity category);
}
