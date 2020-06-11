package org.inori.game.bns.goods_manager.swagger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springfox.documentation.spring.web.readers.parameter.ModelAttributeParameterExpander;

import java.lang.reflect.Method;

/**
 * @author InoriHimea
 * @date 2020/6/11 16:58
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Slf4j
public class SwaggerModelAttributeAdvice {

    /**
     * 方法进入时的通知
     * @param method
     */
    @Advice.OnMethodEnter
    private static void onMethodEnter(@Advice.Origin Method method) {
        log.info("方法进入");
    }

    /**
     * 方法退出时的通知
     * @param method
     * @param allArg
     * @param returnValue
     */
    @Advice.OnMethodExit
    private static void onMethodExit(@Advice.Origin Method method, @Advice.AllArguments Advice.Argument[] allArg,
                                    @Advice.Return Object returnValue) {
        log.info("方法退出");
    }
}
