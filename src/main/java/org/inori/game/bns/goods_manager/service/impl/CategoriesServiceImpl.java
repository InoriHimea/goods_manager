package org.inori.game.bns.goods_manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.CategoriesEntity;
import org.inori.game.bns.goods_manager.repository.CategoriesRepository;
import org.inori.game.bns.goods_manager.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CategoriesServiceImpl implements CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @Override
    public List<CategoriesEntity> findByParentCategoryId(Short id) {
        return categoriesRepository.findByParentCategoryId(id);
    }

    @Override
    public CategoriesEntity save(CategoriesEntity category) {
        return categoriesRepository.saveAndFlush(category);
    }
}
