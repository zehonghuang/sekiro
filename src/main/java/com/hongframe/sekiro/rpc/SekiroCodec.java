package com.hongframe.sekiro.rpc;

import com.hongframe.sekiro.ProtocolCode;
import com.hongframe.sekiro.codec.Codec;
import com.hongframe.sekiro.codec.ProtocolCodeBasedDecoder;
import com.hongframe.sekiro.codec.ProtocolCodeBasedEncoder;
import com.hongframe.sekiro.rpc.protocol.SekiroProtocol;
import com.hongframe.sekiro.rpc.protocol.SekiroProtocolManager;
import io.netty.channel.ChannelHandler;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 23:55
 */
public class SekiroCodec implements Codec {

    static {
        SekiroProtocolManager.initProtocols();
    }

    @Override
    public ChannelHandler encoder() {
        return new ProtocolCodeBasedEncoder(ProtocolCode.fromBytes(SekiroProtocol.SEKIRO_PROTOCOL_CODE));
    }

    @Override
    public ChannelHandler decoder() {
        return new ProtocolCodeBasedDecoder(ProtocolCodeBasedDecoder.DEFAULT_PROTOCOL_VERSION_LENGTH);
    }
}
