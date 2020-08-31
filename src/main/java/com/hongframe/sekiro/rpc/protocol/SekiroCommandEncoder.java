package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.CommandEncoder;
import com.hongframe.sekiro.rpc.cmd.SekiroCommand;
import com.hongframe.sekiro.rpc.cmd.SekiroRequestCommand;
import com.hongframe.sekiro.rpc.cmd.SekiroResponseCommand;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 00:19
 */
public class SekiroCommandEncoder implements CommandEncoder {

    private static final Logger logger = LoggerFactory.getLogger(SekiroCommandEncoder.class);

    @Override
    public void encode(ChannelHandlerContext ctx, Serializable msg, ByteBuf out) {

        if (msg instanceof SekiroCommand) {

            SekiroCommand cmd = (SekiroCommand) msg;

            out.writeByte(SekiroProtocol.SEKIRO_PROTOCOL_CODE);
            out.writeByte(SekiroProtocol.SEKIRO_PROTOCOL_VERSION);
            out.writeShort(cmd.cmdCode().code());
            out.writeByte(cmd.getVersion());
            out.writeInt(cmd.requestId());
            //TODO content codec

            if(cmd instanceof SekiroRequestCommand) {
                SekiroRequestCommand rcmd = (SekiroRequestCommand) cmd;
                out.writeInt(rcmd.getTimeout());
            } else if(cmd instanceof SekiroResponseCommand) {
                SekiroResponseCommand respcmd = (SekiroResponseCommand) cmd;
                out.writeByte(respcmd.getStatus().status());
            }

            out.writeShort(cmd.getClazzLength());
            out.writeShort(cmd.getHeaderLength());
            out.writeInt(cmd.getContentLength());

            if(cmd.getClazzLength() > 0) {
                out.writeBytes(cmd.getClazz());
            }

            if(cmd.getHeaderLength() > 0) {
                out.writeBytes(cmd.getHeader());
            }

            if(cmd.getContentLength() > 0) {
                out.writeBytes(cmd.getContent());
            }

        } else {
            logger.warn("你这个类型老子不支持!!!");
        }

    }
}
