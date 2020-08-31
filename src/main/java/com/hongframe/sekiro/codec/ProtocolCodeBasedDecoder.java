package com.hongframe.sekiro.codec;

import com.hongframe.sekiro.ProtocolCode;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 17:35
 */
public class ProtocolCodeBasedDecoder extends ByteToMessageDecoder {

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

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

    }
}
