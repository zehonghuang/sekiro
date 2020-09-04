package com.hongframe.sekiro.rpc;

import com.hongframe.sekiro.*;
import com.hongframe.sekiro.rpc.cmd.SekiroCommandCode;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-01 15:16
 */
@ChannelHandler.Sharable
public class SekiroHandler extends ChannelInboundHandlerAdapter {

    private RemotingTubeManager tubeManager;

    public SekiroHandler() {
        this.tubeManager = new RemotingTubeManager();
        this.tubeManager.registerTube(SekiroCommandCode.REQUEST, null);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        ProtocolCode protocolCode = ctx.channel().attr(Connection.PROTOCOL_CODE).get();
        Protocol protocol = ProtocolManager.getProtocol(protocolCode);
        protocol.commandHander().handleCommand(new RemotingContext(ctx), msg);
    }
}
