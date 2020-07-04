package org.inori.game.bns.goods_manager;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import lombok.extern.slf4j.Slf4j;
import org.inori.game.bns.goods_manager.agent.SwaggerAgent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"org.inori.game.bns.goods_manager.converter",
        "org.inori.game.bns.goods_manager.entity", "org.inori.game.bns.goods_manager.enums"})
@EnableJpaAuditing
@EnableJpaRepositories("org.inori.game.bns.goods_manager.repository")
@Slf4j
@EnableAdminServer
public class GoodsManagerApplication {

    public static void main(String[] args) {
        SwaggerAgent.getAgent().init();
        SpringApplication.run(GoodsManagerApplication.class, args);
        System.out.println(System.getProperty("user.home"));
    }

    /*private static void swaggerParameterFinderChange() {
        try {
            Method propertyDescriptors = ModelAttributeParameterExpander.class.getDeclaredMethod("propertyDescriptors", Class.class);
            //Method propertyDescriptors1 = SwaggerModelAttributeAdvice.class.getDeclaredMethod("propertyDescriptors",Class.class);

            new ByteBuddy()
                    .subclass(ModelAttributeParameterExpander.class)
                    .method(ElementMatchers.is(propertyDescriptors))
                    .intercept(Advice.to(SwaggerModelAttributeAdvice.class))
                   .method(ElementMatchers.is(propertyDescriptors1))
                    //.intercept(FixedValue.value(Collections.emptySet()))
                    .make()
                   .saveIn(new File("D:/a"));
                    .load(ModelAttributeParameterExpander.class.getClassLoader())
                    .getLoaded();
        } catch (NoSuchMethodException e) {
            log.error("方法未找到", e);
        }
    }*/

}
