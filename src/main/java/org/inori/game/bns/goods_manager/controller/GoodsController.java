package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.GoodsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;
import org.inori.game.bns.goods_manager.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/Goods")
@Slf4j
@Api(value = "物品管理", tags = {"物品管理"})
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 查询物品列表
     * @param size
     * @param no
     * @return
     */
    @GetMapping({"/list/{size}/{no}"})
    public Flux<Page<GoodsEntity>> list(@ApiParam("页大小") @PathVariable int size,
                                        @ApiParam("页号") @PathVariable int no) {
        log.debug("查询物品列表，页大小：{}，页号：{}", size, no);
        return Flux.just(goodsService.findAll(size, no));
    }

    /**
     * 新增一个Good
     * @param good
     * @return
     */
    @PostMapping("/add/one")
    @ApiOperation("创建一个Good")
    public Mono<Boolean> createOne(GoodsEntity good) {
        log.debug("创建一个Good => {}", good);
        try {
            return Mono.just(goodsService.addOne(good) != null);
        } catch (IDExistsException e) {
            return Mono.error(e);
        }
    }

    /**
     * 更新一个Good
     * @param good
     * @return
     */
    @PutMapping("/update/one")
    @ApiOperation("更新一个Good")
    public Mono<Boolean> updateOne(GoodsEntity good) {
        log.debug("更新一个Good => {}", good);
        try {
            return Mono.just(goodsService.updateOne(good) != null);
        } catch (IDNotExistsException e) {
            return Mono.error(e);
        }
    }

    /**
     * 删除一个Good
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除一个Good")
    public Mono<Boolean> deleteOne(@PathVariable int id) {
        log.debug("删除一个Good => {}", id);
        return Mono.just(goodsService.deleteOne(id));
    }
}
