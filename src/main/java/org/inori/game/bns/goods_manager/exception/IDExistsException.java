package org.inori.game.bns.goods_manager.exception;

import lombok.extern.slf4j.Slf4j;

/**
 * @author InoriHimea
 * @date 2020/6/8 19:20
 */
@Slf4j
public class IDExistsException extends Exception {
    public IDExistsException(String s) {
        super(s);
        log.error(s);
    }
}
