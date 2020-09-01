package com.hongframe.sekiro.codec;

import com.hongframe.sekiro.Connection;
import com.hongframe.sekiro.Protocol;
import com.hongframe.sekiro.ProtocolCode;
import com.hongframe.sekiro.ProtocolManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.Objects;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 17:35
 */
public class ProtocolCodeBasedDecoder extends ByteToMessageDecoder {

    public static final int DEFAULT_PROTOCOL_VERSION_LENGTH = 1;

    protected int protocolCodeLength;

    public ProtocolCodeBasedDecoder(int protocolCodeLength) {
        this.protocolCodeLength = protocolCodeLength;
    }

    protected ProtocolCode decodeProtocolCode(ByteBuf in) {
        if (in.readableBytes() >= protocolCodeLength) {
            byte[] protocolCodeBytes = new byte[protocolCodeLength];
            in.readBytes(protocolCodeBytes);
            return ProtocolCode.fromBytes(protocolCodeBytes);
        }
        return null;
    }

    protected byte decodeProtocolVersion(ByteBuf in) {
        if(in.readableBytes() > DEFAULT_PROTOCOL_VERSION_LENGTH) {
            return in.readByte();
        }
        return DEFAULT_PROTOCOL_VERSION_LENGTH;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        ProtocolCode protocolCode = decodeProtocolCode(in);
        if (Objects.nonNull(protocolCode)) {
            byte version = decodeProtocolVersion(in);
            if(ctx.channel().attr(Connection.PROTOCOL_CODE).get() == null) {
                ctx.channel().attr(Connection.PROTOCOL_CODE).set(protocolCode);
                ctx.channel().attr(Connection.VERSION).set(version);
            }

            Protocol protocol = ProtocolManager.getProtocol(protocolCode);
            if(Objects.nonNull(protocol)) {
                protocol.decoder().decode(ctx, in, out);
            } else {
                throw new Exception("没找到这个协议，非常抱歉");
            }
        }
    }
}
