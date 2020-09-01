package com.hongframe.sekiro;

import com.hongframe.sekiro.config.UserConfig;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 21:23
 */
public abstract class AbstractRemotingServer extends AbstractLifeCycle implements RemotingServer {

    private String ip;
    private int port;

    public AbstractRemotingServer(String ip) {
        this.ip = ip;
    }

    @Override
    public void startup() {
        super.startup();

        init(config());
    }

    protected abstract UserConfig config();

    protected abstract void init(UserConfig config);

    protected abstract void start();

    protected abstract void stop0();

    @Override
    public String ip() {
        return this.ip;
    }

    @Override
    public int port() {
        return this.port;
    }
}
