package com.hongframe.sekiro;

import com.hongframe.sekiro.rpc.protocol.UserTube;
import io.netty.channel.ChannelHandlerContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 19:32
 */
public class RemotingContext {

    private ChannelHandlerContext chx;

    private int timeout;

    private ConcurrentHashMap<String, UserTube<?>> userProcessors;

    public RemotingContext(ChannelHandlerContext chx) {
        this.chx = chx;
    }

    public RemotingContext(ChannelHandlerContext chx, ConcurrentHashMap<String, UserTube<?>> userProcessors) {
        this.chx = chx;
        this.userProcessors = userProcessors;
    }

    public ChannelHandlerContext getChx() {
        return chx;
    }

    public void setChx(ChannelHandlerContext chx) {
        this.chx = chx;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public ConcurrentHashMap<String, UserTube<?>> getUserProcessors() {
        return userProcessors;
    }

    public void setUserProcessors(ConcurrentHashMap<String, UserTube<?>> userProcessors) {
        this.userProcessors = userProcessors;
    }

    public Connection getConnection() {
        return this.chx.channel().attr(Connection.CONNECTION).get();
    }
}
