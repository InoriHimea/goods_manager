package org.inori.game.bns.goods_manager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
@Api(value = "主页", tags = {"页面相关"}, hidden = true)
public class HomeController {

    /**
     * 主页跳转，暂为swagger页面
     * @return 页面路径
     */
    @GetMapping("/")
    @ApiOperation (value = "主页跳转", hidden = true)
    public String home() {
        return "redirect:/swagger-ui.html";
    }
}
