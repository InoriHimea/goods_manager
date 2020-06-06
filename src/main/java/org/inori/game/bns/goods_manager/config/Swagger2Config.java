package org.inori.game.bns.goods_manager.config;

import io.swagger.annotations.Info;
import io.swagger.annotations.SwaggerDefinition;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

@Configuration
@Slf4j
//@EnableSwagger2
@EnableSwagger2WebFlux
public class Swagger2Config {

    @Bean
    public Docket swaggerApiConfig() {
        Set<String> protocolSet = new LinkedHashSet<>();
        protocolSet.add("http");
        protocolSet.add("https");

        return new Docket(DocumentationType.SWAGGER_2)
                .enable(true)
                //.enableUrlTemplating(true)
                .forCodeGeneration(true)
                .genericModelSubstitutes(Mono.class, Flux.class, Publisher.class)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.inori.game.bns.goods_manager.controller"))
                .paths(PathSelectors.any())
                .build()
                .protocols(protocolSet)
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(
                SecurityContext.builder()
                            .securityReferences(
                                    Collections.singletonList(new SecurityReference("Authorization",
                                            new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})))
                            .forHttpMethods(httpMethod -> httpMethod.matches("POST") || httpMethod.matches("PUT") || httpMethod.matches("DELETE"))
                            .build()
        );
    }

    private List<BasicAuth> securitySchemes() {
        //return Collections.singletonList(new ApiKey("Bearer", "Authorization", "header"));
        return Collections.singletonList(new BasicAuth("Authorization"));
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
