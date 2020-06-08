package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.ItemsEntity;
import org.inori.game.bns.goods_manager.model.SelectOption;
import org.inori.game.bns.goods_manager.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/Items")
@Slf4j
@Api(value = "项目管理", tags = {"项目管理"})
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 列出Items
     * @return
     */
    @GetMapping("/list/{size}/{no}")
    @ApiOperation ("查询所有项目")
    public Flux<List<ItemsEntity>> getItems(@ApiParam(value="页大小", required = true) @PathVariable int size,
                                            @ApiParam(value = "页号", required = true) @PathVariable int no) {
        return null;
    }

    /**
     * 获取Items为Select选择使用
     * @return
     */
    @GetMapping("/get/options")
    @ApiOperation(value = "获取所有项目为下拉框", notes = "此方法速度比较慢，不建议使用")
    public Mono<List<SelectOption<Integer>>> getItemsOptions() {
        return Mono.just(itemsService.getItemsOptions());
    }
}
