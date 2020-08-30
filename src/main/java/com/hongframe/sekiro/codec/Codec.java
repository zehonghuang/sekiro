package com.hongframe.sekiro.codec;

import io.netty.channel.ChannelHandler;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 23:54
 */
public interface Codec {

    ChannelHandler encoder();

    ChannelHandler decoder();

}
