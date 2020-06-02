package org.inori.game.bns.goods_manager.repository;

import org.inori.game.bns.goods_manager.entity.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Short> {

    List<CategoriesEntity> findByParentCategoryId(Short id);
}
