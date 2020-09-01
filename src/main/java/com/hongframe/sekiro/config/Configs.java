package com.hongframe.sekiro.config;

import com.hongframe.sekiro.serialization.HessianSerializer;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-01 14:13
 */
public class Configs {
    /** TCP_NODELAY option */
    public static final String TCP_NODELAY                           = "sekiro.tcp.nodelay";
    public static final String TCP_NODELAY_DEFAULT                   = "true";

    /** TCP SO_REUSEADDR option */
    public static final String TCP_SO_REUSEADDR                      = "sekiro.tcp.so.reuseaddr";
    public static final String TCP_SO_REUSEADDR_DEFAULT              = "true";

    /** TCP SO_BACKLOG option */
    public static final String TCP_SO_BACKLOG                        = "sekiro.tcp.so.backlog";
    public static final String TCP_SO_BACKLOG_DEFAULT                = "1024";

    /** TCP SO_KEEPALIVE option */
    public static final String TCP_SO_KEEPALIVE                      = "sekiro.tcp.so.keepalive";
    public static final String TCP_SO_KEEPALIVE_DEFAULT              = "true";

    /** TCP SO_SNDBUF option */
    public static final String TCP_SO_SNDBUF                         = "sekiro.tcp.so.sndbuf";
    /** TCP SO_RCVBUF option */
    public static final String TCP_SO_RCVBUF                         = "sekiro.tcp.so.rcvbuf";

    /** Netty ioRatio option*/
    public static final String NETTY_IO_RATIO                        = "sekiro.netty.io.ratio";
    public static final String NETTY_IO_RATIO_DEFAULT                = "70";

    /** Netty buffer allocator, enabled as default */
    public static final String NETTY_BUFFER_POOLED                   = "sekiro.netty.buffer.pooled";
    public static final String NETTY_BUFFER_POOLED_DEFAULT           = "true";

    /** Netty buffer high watermark */
    public static final String NETTY_BUFFER_HIGH_WATERMARK           = "sekiro.netty.buffer.high.watermark";
    public static final String NETTY_BUFFER_HIGH_WATERMARK_DEFAULT   = Integer.toString(64 * 1024);

    /** Netty buffer low watermark */
    public static final String NETTY_BUFFER_LOW_WATERMARK            = "sekiro.netty.buffer.low.watermark";
    public static final String NETTY_BUFFER_LOW_WATERMARK_DEFAULT    = Integer.toString(32 * 1024);

    /** Netty epoll switch */
    public static final String NETTY_EPOLL_SWITCH                    = "sekiro.netty.epoll.switch";
    public static final String NETTY_EPOLL_SWITCH_DEFAULT            = "true";

    /** Netty epoll level trigger enabled */
    public static final String NETTY_EPOLL_LT                        = "sekiro.netty.epoll.lt";
    public static final String NETTY_EPOLL_LT_DEFAULT                = "true";

    // ~~~ configs and default values for serializer

    /** Codec type */
    public static final String SERIALIZER                            = "sekiro.serializer";
    public static final String SERIALIZER_DEFAULT                    = String
            .valueOf(HessianSerializer.HESSIAN_SERIALIZER);

    /** Charset */
    public static final String DEFAULT_CHARSET                       = "UTF-8";
}
