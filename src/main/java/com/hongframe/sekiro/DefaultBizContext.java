package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 16:00
 */
public class DefaultBizContext implements BizContext {

    private RemotingContext remotingCtx;

    public DefaultBizContext(RemotingContext remotingCtx) {
        this.remotingCtx = remotingCtx;
    }

    @Override
    public Connection getConnection() {
        if (null != this.remotingCtx) {
            return this.remotingCtx.getConnection();
        }
        return null;
    }

    @Override
    public int getClientTimeout() {
        return this.remotingCtx.getTimeout();
    }

    @Override
    public void put(String key, String value) {

    }

    @Override
    public String get(String key) {
        return null;
    }
}
