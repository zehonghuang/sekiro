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

    private byte type;

    private CommandCode cmdCode;
    private byte version = 0x1;

    private int requestId;
    private byte serializer;// as codec

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
        return null;//TODO
    }

    public void setCmdCode(CommandCode cmdCode) {
        this.cmdCode = cmdCode;
    }

    @Override
    public CommandCode cmdCode() {
        return this.cmdCode;
    }

    public byte getVersion() {
        return version;
    }

    public void setVersion(byte version) {
        this.version = version;
    }

    @Override
    public int requestId() {
        return this.requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public byte getSerializer() {
        return serializer;
    }

    public void setSerializer(byte serializer) {
        this.serializer = serializer;
    }

    public short getClazzLength() {
        return clazzLength;
    }

    public short getHeaderLength() {
        return headerLength;
    }

    public int getContentLength() {
        return contentLength;
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
