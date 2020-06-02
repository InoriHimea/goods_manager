package org.inori.game.bns.goods_manager.controller;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.model.SelectOption;
import org.inori.game.bns.goods_manager.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/Items")
@Slf4j
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    /**
     * 获取Items为Select选择使用
     * @return
     */
    @GetMapping("/get/options")
    public Mono<List<SelectOption<Integer>>> getItemsOptions() {
        return Mono.just(itemsService.getItemsOptions());
    }
}
