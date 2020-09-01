package com.hongframe.sekiro;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 19:24
 */
public abstract class AbstractLifeCycle implements LifeCycle {

    private AtomicBoolean isStartup = new AtomicBoolean(false);

    @Override
    public void startup() {
        if(isStartup.compareAndSet(false, true)) {
            return;
        }
        throw new LifeCycleException("Started!!!");
    }

    @Override
    public boolean isStarted() {
        return this.isStartup.get();
    }
}
