package com.hongframe.sekiro;

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

        init();
    }

    protected abstract void init();

    protected abstract void start();

    protected abstract void stop0();

    public String ip() {
        return this.ip;
    }

    public int port() {
        return this.port;
    }
}
