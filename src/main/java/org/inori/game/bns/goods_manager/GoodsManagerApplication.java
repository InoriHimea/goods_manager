package org.inori.game.bns.goods_manager;

import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"org.inori.game.bns.goods_manager.converter",
        "org.inori.game.bns.goods_manager.entity", "org.inori.game.bns.goods_manager.enums"})
@EnableJpaAuditing
@EnableJpaRepositories("org.inori.game.bns.goods_manager.repository")
public class GoodsManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsManagerApplication.class, args);
    }

}
