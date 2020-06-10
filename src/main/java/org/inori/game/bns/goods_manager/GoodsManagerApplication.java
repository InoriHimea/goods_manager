package org.inori.game.bns.goods_manager;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.matcher.NameMatcher;
import org.inori.game.bns.goods_manager.converter.LanguageCodeConverter;
import org.inori.game.bns.goods_manager.swagger.ModelAttributeCanIgnoreParameterExpander;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.spring.web.readers.parameter.ModelAttributeParameterExpander;

@SpringBootApplication
@EntityScan(basePackages = {"org.inori.game.bns.goods_manager.converter",
        "org.inori.game.bns.goods_manager.entity", "org.inori.game.bns.goods_manager.enums"})
@EnableJpaAuditing
@EnableJpaRepositories("org.inori.game.bns.goods_manager.repository")
@Slf4j
public class GoodsManagerApplication {

    public static void main(String[] args) {
        swaggerParameterFinderChange();
        SpringApplication.run(GoodsManagerApplication.class, args);
    }

    private static void swaggerParameterFinderChange() {
        Class<? extends ModelAttributeParameterExpander> clazz = new ByteBuddy()
                .redefine(ModelAttributeParameterExpander.class)
                .method(ElementMatchers.named("propertyDescriptors"))
                .intercept(MethodDelegation.to(ModelAttributeCanIgnoreParameterExpander.class))
                .make()
                .load(GoodsManagerApplication.class.getClass().getClassLoader())
                .getLoaded();

        log.info("新的类：{}", clazz);
    }

}
