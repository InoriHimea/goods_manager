package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.CategoriesEntity;
import org.inori.game.bns.goods_manager.entity.CategoryDisplayEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;
import org.inori.game.bns.goods_manager.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/Category")
@Api(value = "分类管理", tags = {"分类管理"})
public class CategoriesController {

    @Autowired
    private CategoriesService categoriesService;

    /**
     * 通过递归查询获取所有的分类（以树的形式展现）
     * @return
     */
    @GetMapping("/tree")
    @ApiOperation("通过树的形式获取所有分类")
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
    @ApiOperation("添加一个新的分类，如果ID存在，会抛出异常")
    public Mono<Boolean> addOneCategory(@ApiParam(value = "分类", required = true) CategoriesEntity category) {
        log.debug("添加一个分类 => {}", category);
        try {
            return Mono.just(categoriesService.save(category) != null);
        } catch (IDExistsException e) {
            return Mono.error(e);
        }
    }

    /**
     * 更新一个分类，需要对用内容
     * @param category
     * @return
     */
    @PutMapping("/update/one")
    @ApiOperation("更新一个分类，如果ID不存在，则抛出异常")
    public Mono<Boolean> updateOneCategory(CategoriesEntity category) {
        log.debug("更新一个分类 => {}", category);
        try {
            return Mono.just(categoriesService.update(category) != null);
        } catch (IDNotExistsException e) {
            return Mono.error(e);
        }
    }

    /**
     * 删除一个分类
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除一个分类，同时删除关联数据")
    public Mono<Boolean> deleteOneCategory(@ApiParam(value = "需要删除的内容的ID", required = true) @PathVariable("id") Short id) {
        log.debug ("删除一个分类 => {}", id);
        return Mono.just (categoriesService.delete(id));
    }
}
