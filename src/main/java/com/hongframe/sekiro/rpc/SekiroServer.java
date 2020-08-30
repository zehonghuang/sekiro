package com.hongframe.sekiro.rpc;

import com.hongframe.sekiro.AbstractRemotingServer;
import com.hongframe.sekiro.codec.Codec;
import com.hongframe.sekiro.utils.NamedThreadFactory;
import com.hongframe.sekiro.utils.NettyUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 18:36
 */
public class SekiroServer extends AbstractRemotingServer {

    private ServerBootstrap bootstrap;

    private EventLoopGroup bossGroup = NettyUtil
            .newEventLoopGroup(
                    1,
                    new NamedThreadFactory(
                            "Rpc-netty-server-boss",
                            false));

    private EventLoopGroup workGroup = NettyUtil
            .newEventLoopGroup(
                    Runtime.getRuntime().availableProcessors() * 2,
                    new NamedThreadFactory(
                            "Rpc-netty-server-boss",
                            false));

    private Codec codec = new SekiroCodec();

    public SekiroServer(String ip) {
        super(ip);
    }

    @Override
    protected void init() {

        this.bootstrap = new ServerBootstrap();
        this.bootstrap.group(this.bossGroup, this.workGroup)
                .channel(NettyUtil.getServerSocketChannelClass())
                .option(ChannelOption.SO_BACKLOG, 1024)
                .option(ChannelOption.SO_REUSEADDR, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.SO_SNDBUF, null)
                .option(ChannelOption.SO_RCVBUF, null);

        this.bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                pipeline.addLast("decoder", codec.decoder());
                pipeline.addLast("encoder", codec.encoder());
            }
        });

    }

    @Override
    protected void start() {

    }

    @Override
    protected void stop0() {

    }

    public void shutdown() {

    }
}
