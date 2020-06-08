package org.inori.game.bns.goods_manager.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.CategoriesEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;
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
    public CategoriesEntity save(CategoriesEntity category) throws IDExistsException {
        if (categoriesRepository.existsById(category.getCategoryId ())) {
            throw new IDExistsException ("对应的ID已存在，请更换或使用update方法");
        }
        return categoriesRepository.saveAndFlush(category);
    }

    @Override
    public CategoriesEntity update(CategoriesEntity category) throws IDNotExistsException {
        if (! categoriesRepository.existsById(category.getCategoryId ())) {
            throw new IDNotExistsException ("对应的ID不存在，请更换或使用create方法");
        }
        return categoriesRepository.saveAndFlush(category);
    }

    @Override
    public Boolean delete(Short id) {
        categoriesRepository.deleteById ( id );
        return ! categoriesRepository.existsById ( id );
    }
}
