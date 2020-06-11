package org.inori.game.bns.goods_manager.agent;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.inori.game.bns.goods_manager.swagger.SwaggerModelAttributeAdvice;
import org.inori.game.bns.goods_manager.swagger.SwaggerModelAttributeMethodDelegation;

/**
 * @author InoriHimea
 * @date 2020/6/11 13:32
 */
@Slf4j
public class SwaggerAgent {

    private static final SwaggerAgent agent = new SwaggerAgent();
    private SwaggerAgent(){}
    public static SwaggerAgent getAgent() {
        return agent;
    }

    public void init() {
        log.info("ByteBuddy Agent start init");

        ByteBuddyAgent.install();
        synchronized (SwaggerAgent.class) {
            new AgentBuilder.Default()
                    .type(ElementMatchers.nameStartsWith("springfox."))
                    //.type(ElementMatchers.is(ModelAttributeParameterExpander.class))
                    /*.transform((builder, typeDescription, classLoader, module) ->
                            builder.visit(Advice.to(SwaggerModelAttributeAdvice.class)
                                    .on(ElementMatchers.any())))*/
                    .transform((builder, typeDescription, classLoader, module) ->
                            builder.method(ElementMatchers.named("propertyDescriptors"))
                                    .intercept(MethodDelegation.to(SwaggerModelAttributeMethodDelegation.class)))
                    .installOnByteBuddyAgent();

            log.info("ByteBuddy Agent init success");
        }
    }
}
