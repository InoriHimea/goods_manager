package org.inori.game.bns.goods_manager.listener;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.agent.ByteBuddyAgent;
import org.inori.game.bns.goods_manager.agent.SwaggerAgent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author InoriHimea
 * @date 2020/6/11 14:44
 */
@Component
@Slf4j
public class AppEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        log.debug("你要赶什么");
    }
}
