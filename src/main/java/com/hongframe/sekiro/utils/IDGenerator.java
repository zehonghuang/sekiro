package com.hongframe.sekiro.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 22:46
 */
public class IDGenerator {

    private final static AtomicInteger id = new AtomicInteger(0);

    public static int nextId() {
        return id.incrementAndGet();
    }


}
