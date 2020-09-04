package com.hongframe.sekiro.rpc;

import com.hongframe.sekiro.AbstractRemotingServer;
import com.hongframe.sekiro.codec.Codec;
import com.hongframe.sekiro.config.UserConfig;
import com.hongframe.sekiro.rpc.protocol.UserTube;
import com.hongframe.sekiro.utils.NamedThreadFactory;
import com.hongframe.sekiro.utils.NettyUtil;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.buffer.UnpooledByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import org.apache.commons.lang3.StringUtils;

import java.net.InetSocketAddress;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 18:36
 */
public class SekiroServer extends AbstractRemotingServer {

    private ServerBootstrap bootstrap;

    private ChannelFuture channelFuture;

    private UserConfig config;

    private ConcurrentHashMap<String, UserTube<?>> userTubes =
            new ConcurrentHashMap<String, UserTube<?>>(4);


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

    private final Codec codec = new SekiroCodec();

    public SekiroServer(int port) {
        super(port);
    }

    public SekiroServer(String ip, int port) {
        super(ip, port);
    }

    @Override
    protected void init(UserConfig config) {

        this.config = config;

        this.bootstrap = new ServerBootstrap();
        this.bootstrap.group(this.bossGroup, this.workGroup)
                .channel(NettyUtil.getServerSocketChannelClass())
                .option(ChannelOption.SO_BACKLOG, this.config.getTcp_so_backlog())
                .option(ChannelOption.SO_REUSEADDR, this.config.isTcp_so_reuseaddr())

                .childOption(ChannelOption.TCP_NODELAY, this.config.isTcp_nodelay())
                .childOption(ChannelOption.SO_KEEPALIVE, this.config.getTcp_so_keepalive())
                .childOption(ChannelOption.SO_SNDBUF, this.config.getTcp_so_sndbuf())
                .childOption(ChannelOption.SO_RCVBUF, this.config.getTcp_so_rcvbuf());

        if (this.config.getNetty_buffer_pooled()) {
            this.bootstrap.option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
        } else {
            this.bootstrap.option(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT)
                    .childOption(ChannelOption.ALLOCATOR, UnpooledByteBufAllocator.DEFAULT);

        }

        SekiroHandler sekiro = new SekiroHandler();

        this.bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();

                pipeline.addLast("decoder", codec.decoder());
                pipeline.addLast("encoder", codec.encoder());

                pipeline.addLast(sekiro);
            }
        });

    }

    public void setConfig(UserConfig config) {
        this.config = config;
    }

    @Override
    protected UserConfig config() {
        return this.config;
    }

    @Override
    protected boolean start()throws InterruptedException {
        this.channelFuture = this.bootstrap.bind(new InetSocketAddress(ip(), port())).sync();
        return this.channelFuture.isSuccess();
    }

    @Override
    protected void stop0() {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void registerUserTube(UserTube<?> tube) {
        if (Objects.isNull(tube)) {
            throw new RuntimeException("user tube should not be null!");
        }
        if (StringUtils.isBlank(tube.identity())) {
            throw new RuntimeException("identity should not be blank!");
        }
        UserTube userTube = this.userTubes.putIfAbsent(tube.identity(), tube);
        if (Objects.nonNull(userTube)) {
            throw new RuntimeException("can not register again!");
        }
    }
}
