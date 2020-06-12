package org.inori.game.bns.goods_manager.config;

import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.converter.EnumConverterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * @author InoriHimea
 * @date 2020/6/12 17:15
 */
@Configuration
@Slf4j
public class WebFluxConfig implements WebFluxConfigurer {

    @Bean
    public EnumConverterFactory enumConverterFactory() {
        return new EnumConverterFactory();
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverterFactory(enumConverterFactory());
    }
}
