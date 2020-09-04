package com.hongframe.sekiro.rpc.cmd;

import com.hongframe.sekiro.ResponseStatus;

import java.net.InetSocketAddress;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 14:08
 */
public class SekiroResponseCommand extends SekiroCommand {

    private Object response;

    private String responseClass;

    private ResponseStatus status;

    private long responseTimeMillis;

    private InetSocketAddress responseHost;

    private Throwable cause;

    public SekiroResponseCommand(Object response) {
        super(SekiroCommandType.RESPONSE);
        this.response = response;
    }

    public SekiroResponseCommand() {
        super(SekiroCommandType.RESPONSE);
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
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

    @Override
    public void serialize() {

    }

    @Override
    public void deserialize() {

    }
}
