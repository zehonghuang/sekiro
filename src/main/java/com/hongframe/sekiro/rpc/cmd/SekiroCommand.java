package com.hongframe.sekiro.rpc.cmd;

import com.hongframe.sekiro.CommandCode;
import com.hongframe.sekiro.ProtocolCode;
import com.hongframe.sekiro.RemotingCommand;

import java.util.Objects;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 13:48
 */
public abstract class SekiroCommand implements RemotingCommand {

    private CommandCode cmdCode;
    private byte version;
    private byte type;

    private int requestId;

    private short clazzLength;
    private short headerLength;
    private int contentLength;

    private byte[] clazz;
    private byte[] header;
    private byte[] content;

    public SekiroCommand(byte type) {
        this.type = type;
    }

    @Override
    public ProtocolCode protoVersion() {
        return null;
    }

    @Override
    public CommandCode cmdCode() {
        return null;
    }

    @Override
    public int requestId() {
        return 0;
    }

    public byte[] getClazz() {
        return clazz;
    }

    public void setClazz(byte[] clazz) {
        if(Objects.nonNull(clazz)) {
            this.clazz = clazz;
            this.clazzLength = (short) clazz.length;
        }

    }

    public byte[] getHeader() {
        return header;
    }

    public void setHeader(byte[] header) {
        if(Objects.nonNull(header)) {
            this.header = header;
            this.headerLength = (short) header.length;
        }

    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        if(Objects.nonNull(content)) {
            this.content = content;
            this.contentLength = content.length;
        }

    }
}
