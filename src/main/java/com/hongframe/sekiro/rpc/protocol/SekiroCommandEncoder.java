package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.CommandEncoder;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import java.io.Serializable;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 00:19
 */
public class SekiroCommandEncoder implements CommandEncoder {
    public void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) {



    }
}