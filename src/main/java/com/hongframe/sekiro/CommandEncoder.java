package com.hongframe.sekiro;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.Serializable;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 00:16
 */
public interface CommandEncoder {

    void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out);

}
