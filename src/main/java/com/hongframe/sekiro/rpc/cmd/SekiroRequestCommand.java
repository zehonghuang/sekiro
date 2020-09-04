package com.hongframe.sekiro.rpc.cmd;


import com.hongframe.sekiro.utils.IDGenerator;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 14:00
 */
public class SekiroRequestCommand extends SekiroCommand {

    private String requestClass;
    private Object requestHeader;
    private Object request;

    private int timeout = -1;

    public SekiroRequestCommand(Object request) {
        super(SekiroCommandType.REQUEST);
        this.setRequestId(IDGenerator.nextId());
        this.request = request;
    }

    public SekiroRequestCommand() {
        super(SekiroCommandType.REQUEST);
    }

    public String getRequestClass() {
        return requestClass;
    }

    public void setRequestClass(String requestClass) {
        this.requestClass = requestClass;
    }

    public Object getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(Object requestHeader) {
        this.requestHeader = requestHeader;
    }

    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    @Override
    public void serialize() {

    }

    @Override
    public void deserialize() {

    }
}
