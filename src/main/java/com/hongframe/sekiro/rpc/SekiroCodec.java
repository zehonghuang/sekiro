package com.hongframe.sekiro.rpc;

import com.hongframe.sekiro.codec.Codec;
import io.netty.channel.ChannelHandler;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 23:55
 */
public class SekiroCodec implements Codec {
    @Override
    public ChannelHandler encoder() {
        return null;
    }

    @Override
    public ChannelHandler decoder() {
        return null;
    }
}
