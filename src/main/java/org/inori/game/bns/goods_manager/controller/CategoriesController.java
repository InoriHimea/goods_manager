package org.inori.game.bns.goods_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.CategoriesEntity;
import org.inori.game.bns.goods_manager.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/Category")
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    /**
     * 通过递归查询获取所有的分类（以树的形式展现）
     * @return
     */
    @GetMapping("/tree")
    public Mono<List<CategoriesEntity>> listCategoryTree() {
        return Mono.just(categoriesService.findByParentCategoryId(null));
    }

    /**
     * <code>
     *     <Request>
         *     <CategoryId>分类的ID</CategoryId>
         *     <CategoryName>分类的名称</CategoryName>
         *     <AppGroupCode>bnsgrnTH</AppGroupCode> --通过AppGroup库查询，此处作为默认
         *     <IsDisplayable>0/1</IsDisplayable>
         *     <DisplayOrder>3</DisplayOrder>
         *     <ChangerAdminAccount>GoodsManagerUser</ChangerAdminAccount>
         *     <CurrencyGroupId>71</CurrencyGroupId>
         *     <ParentCategoryId>4</ParentCategoryId>
         *     <CategoryData>{"CategoryType":["01"]}</CategoryData>
         *     <CategoryDisplays type="array">
         *         <CategoryDisplay>
         *             <LanguageCode>1</LanguageCode>
         *             <CategoryDisplayName>显示名</CategoryDisplayName>
         *             <CategoryDisplayDescription>描述</CategoryDisplayDescription>
         *         </CategoryDisplay>
         *         <CategoryDisplay>
         *             <LanguageCode>2</LanguageCode>
         *             <CategoryDisplayName>Console Add Category Display Name 2</CategoryDisplayName>
         *             <CategoryDisplayDescription>Console Add Category Display Description 2</CategoryDisplayDescription>
         *         </CategoryDisplay>
         *     </CategoryDisplays>
         * </Request>
     * </code>
     * 添加一个新的分类
     * @return
     */
    @PostMapping("/add/one")
    public Mono<Boolean> addOneCategory(CategoriesEntity category) {
        log.debug("添加一个分类 => {}", category);
        return Mono.just(categoriesService.save(category) != null);
    }

    /**
     * 更新一个分类，需要对用内容
     * @param category
     * @return
     */
    @PutMapping("/update/one")
    public Mono<Boolean> updateOneCategory(CategoriesEntity category) {
        log.debug("更新一个分类 => {}", category);
        return Mono.just(categoriesService.update(category) != null);
    }
}
