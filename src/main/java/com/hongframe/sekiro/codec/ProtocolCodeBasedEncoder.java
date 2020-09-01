package com.hongframe.sekiro.codec;

import com.hongframe.sekiro.Connection;
import com.hongframe.sekiro.Protocol;
import com.hongframe.sekiro.ProtocolCode;
import com.hongframe.sekiro.ProtocolManager;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.Attribute;

import java.io.Serializable;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 22:54
 */
public class ProtocolCodeBasedEncoder extends MessageToByteEncoder<Serializable> {

    protected ProtocolCode defaultProtocolCode;

    public ProtocolCodeBasedEncoder(ProtocolCode defaultProtocolCode) {
        super();
        this.defaultProtocolCode = defaultProtocolCode;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) throws Exception {

        Attribute<ProtocolCode> attr = ctx.channel().attr(Connection.PROTOCOL_CODE);
        ProtocolCode protocolCode;
        if(attr == null || attr.get() == null) {
            protocolCode = this.defaultProtocolCode;
        } else  {
            protocolCode = attr.get();
        }
        Protocol protocol = ProtocolManager.getProtocol(protocolCode);
        protocol.encoder().encode(ctx, msg, out);
    }
}
