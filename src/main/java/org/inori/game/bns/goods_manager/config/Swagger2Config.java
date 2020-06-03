package org.inori.game.bns.goods_manager.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@Configuration
@Slf4j
//@EnableSwagger2
@EnableSwagger2WebFlux
public class Swagger2Config {

    @Bean
    public Docket swaggerApiConfig() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                .enableUrlTemplating(true)
                .forCodeGeneration(true)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.inori.game.bns.goods_manager.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .version("1.0")
                .description("一个建议的物品管理API")
                .license("My Own Little API")
                .termsOfServiceUrl("http://api.myinori0114.ml")
                .title("GoodsDBApi")
                .licenseUrl("http://license.myinori011.ml")
                .contact(new Contact("InoriAsuka", "http://home.myinori0114.ml", "icarus347@gmail.com"))
                .build();
    }
}
