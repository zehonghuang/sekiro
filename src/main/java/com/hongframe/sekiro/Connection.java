package com.hongframe.sekiro;

import io.netty.channel.Channel;
import io.netty.util.AttributeKey;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 21:56
 */
public class Connection {

    public static final AttributeKey<ProtocolCode> PROTOCOL_CODE = AttributeKey.valueOf("protocol_code");

    public static final AttributeKey<Byte> VERSION = AttributeKey.valueOf("version");

    public static final AttributeKey<Connection> CONNECTION = AttributeKey.valueOf("connection");

    private Channel channel;

    public Connection(Channel channel) {
        this.channel = channel;
        this.channel.attr(CONNECTION).set(this);
    }
}
