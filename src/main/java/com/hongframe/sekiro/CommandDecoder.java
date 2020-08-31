package com.hongframe.sekiro;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.util.List;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 10:40
 */
public interface CommandDecoder {

    void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out);

}
