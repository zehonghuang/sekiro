package com.hongframe.sekiro.rpc.cmd;

import com.hongframe.sekiro.ResponseStatus;

import java.net.InetSocketAddress;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 14:08
 */
public class SekiroResponseCommand extends SekiroCommand {

    private ResponseStatus status;

    private long responseTimeMillis;

    private InetSocketAddress responseHost;

    private Throwable cause;

    public SekiroResponseCommand() {
        super(SekiroCommandType.RESPONSE);
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public long getResponseTimeMillis() {
        return responseTimeMillis;
    }

    public void setResponseTimeMillis(long responseTimeMillis) {
        this.responseTimeMillis = responseTimeMillis;
    }

    public InetSocketAddress getResponseHost() {
        return responseHost;
    }

    public void setResponseHost(InetSocketAddress responseHost) {
        this.responseHost = responseHost;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
