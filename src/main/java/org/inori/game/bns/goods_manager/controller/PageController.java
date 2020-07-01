package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Slf4j
@Api(value = "主页", tags = {"页面相关"}, hidden = true)
public class PageController {

    /**
     * 主页跳转，暂为swagger页面
     * @return 页面路径
     */
    @GetMapping("/")
    @ApiOperation (value = "主页跳转", hidden = true)
    public String home(Model model, ServerHttpRequest request) {
        model.addAttribute("title", "简易首页");
        model.addAttribute("ip", request.getRemoteAddress());
        return "index";
        //return "redirect:/swagger-ui.html";
    }

    @GetMapping("/status")
    @ApiOperation(value = "显示项目状态页",  hidden = true)
    public Mono<String> status(Model model) {
        model.addAttribute("name", "GoodsDBManager");
        return Mono.create (mono -> mono.success("status"));
    }

    @GetMapping("/time")
    @ResponseBody
    @ApiOperation(value = "服务器时间", hidden = true)
    public Flux<ServerSentEvent<String>> time() {
        return Flux.interval(Duration.ofMillis(1000))
                .map(data -> ServerSentEvent.<String>builder()
                        .data(LocalDateTime.now().format (DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                        .build());
    }
}
