package org.inori.game.bns.goods_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.entity.SubscriptionItemsEntity;
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
public class SubscriptionController {

    @Autowired
    private SubscriptionService subscriptionService;

    /**
     * 查询指定大小和页号的订阅消息
     * @param size
     * @param no
     * @return
     */
    @GetMapping("/list/{size}/{no}")
    public Flux<Page<SubscriptionItemsEntity>> list(@PathVariable int size, @PathVariable int no) {
        log.debug("查询订阅列表, 页号：{}，页大小：{}", size, no);
        return Flux.just(subscriptionService.findAll(size, no));
    }

    /**
     * 添加一个订阅
     * @return
     */
    @PostMapping("/add/one")
    public Mono<Boolean> addOne(SubscriptionItemsEntity subscription) {
        log.debug("添加一条订阅 => {}", subscription);

        return Mono.just(true);
    }
}
