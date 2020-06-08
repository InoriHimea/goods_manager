package org.inori.game.bns.goods_manager.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author InoriHimea
 * @date 2020/6/8 19:37
 */
@Slf4j
public class IDNotExistsException extends Exception {

    public IDNotExistsException(String s) {
        super(s);
        log.error(s);
    }
}
