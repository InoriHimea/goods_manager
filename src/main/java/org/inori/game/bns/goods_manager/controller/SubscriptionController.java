package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.SubscriptionItemsEntity;
import org.inori.game.bns.goods_manager.exception.IDExistsException;
import org.inori.game.bns.goods_manager.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/Subscription")
@Slf4j
@Api(value = "推送项目管理", tags = {"项目管理"})
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    /**
     * 查询指定大小和页号的订阅消息
     * @param size
     * @param no
     * @return
     */
    @GetMapping({"/list/{size}/{no}"})
    @ApiOperation(value ="查询推送项目列表")
    public Flux<Page<SubscriptionItemsEntity>> list(@ApiParam(value = "页大小", required = true) @PathVariable int size,
                                                    @ApiParam(value = "页号", required = true) @PathVariable int no) {
        log.debug("查询订阅列表, 页号：{}，页大小：{}", size, no);
        return Flux.just(subscriptionService.findAll(size, no));
    }

    /**
     * 添加一个订阅
     * @return
     */
    @PostMapping("/add/one")
    @ApiOperation("增加一条推送项目")
    public Mono<Boolean> addOne(@ApiParam("推送项目内容") SubscriptionItemsEntity subscription) {
        log.debug("添加一条订阅 => {}", subscription);
        try {
            return Mono.just(subscriptionService.save(subscription) != null);
        } catch (IDExistsException e) {
            return Mono.error(e);
        }
    }
}
