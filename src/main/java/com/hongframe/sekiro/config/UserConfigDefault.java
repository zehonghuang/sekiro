package com.hongframe.sekiro.config;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 09:13
 */
public final class UserConfigDefault {

    public static final Boolean TCP_NODELAY_DEFAULT = true;

    public static final Boolean TCP_SO_REUSEADDR_DEFAULT = true;

    public static final Integer TCP_SO_BACKLOG_DEFAULT = 1024;

    public static final Boolean TCP_SO_KEEPALIVE_DEFAULT = true;

    public static final Integer NETTY_IO_RATIO_DEFAULT = 70;

    public static final Boolean NETTY_BUFFER_POOLED_DEFAULT = true;

    public static final Integer NETTY_BUFFER_HIGH_WATERMARK_DEFAULT = 64 * 1024;

    public static final Integer NETTY_BUFFER_LOW_WATERMARK_DEFAULT = 32 * 1024;

    public static final Boolean NETTY_EPOLL_DEFAULT = true;

    public static final Boolean NETTY_EPOLL_LT_DEFAULT = true;
}
