package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.GoodsEntity;
import org.inori.game.bns.goods_manager.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
}
