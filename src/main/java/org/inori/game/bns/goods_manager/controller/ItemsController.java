package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.ItemsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.exception.IDNotExistsException;
import org.inori.game.bns.goods_manager.model.SelectOption;
import org.inori.game.bns.goods_manager.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
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
    public Flux<Page<ItemsEntity>> getItems(@ApiParam(value="页大小", required = true) @PathVariable int size,
                                            @ApiParam(value = "页号", required = true) @PathVariable int no) {
        return Flux.just(itemsService.findAll(size, no));
    }

    /**
     * 获取Items为Select选择使用
     * @return
     */
    @GetMapping("/get/options")
    @ApiOperation(value = "获取所有项目为下拉框", notes = "此方法速度比较慢，不建议使用")
    @Deprecated
    public Mono<List<SelectOption<Integer>>> getItemsOptions() {
        return Mono.just(itemsService.getItemsOptions());
    }

    @PostMapping("/add/one")
    @ApiOperation("新增一个Item")
    public Mono<Boolean> saveOne(ItemsEntity item) {
        log.debug("新增一个Item => {}", item);

        try {
            return Mono.just(itemsService.save(item) != null);
        } catch (IDExistsException e) {
            return Mono.error(e);
        }
    }

    @PutMapping("/update/one")
    @ApiOperation("更新一个Item")
    public Mono<Boolean> updateOne(ItemsEntity item) {
        log.debug("更新一个Item => {}", item);

        try {
            return Mono.just(itemsService.update(item) != null);
        } catch (IDNotExistsException e) {
            return Mono.error(e);
        }
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除一个Item")
    public Mono<Boolean> deleteOne(@PathVariable int id) {
        log.debug("删除一个Item => {}", id);
        return Mono.just(itemsService.delete(id));
    }
}
