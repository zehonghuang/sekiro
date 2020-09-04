package com.hongframe.sekiro.config;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-01 14:16
 */
public class UserConfig {

    private Boolean tcp_nodelay;

    private Boolean tcp_so_reuseaddr;

    private Integer tcp_so_backlog;

    private Boolean tcp_so_keepalive;

    private Integer tcp_so_sndbuf;

    private Integer tcp_so_rcvbuf;

    private Integer netty_io_ratio;

    private Boolean netty_buffer_pooled;

    private Integer netty_buffer_high_watermark;

    private Integer netty_buffer_low_watermark;

    private Boolean netty_epoll;

    private Boolean netty_epoll_lt;

    public static final String DEFAULT_CHARSET = "UTF-8";

    private UserConfig(Boolean tcp_nodelay,
                       Boolean tcp_so_reuseaddr,
                       Integer tcp_so_backlog,
                       Boolean tcp_so_keepalive,
                       Integer tcp_so_sndbuf,
                       Integer tcp_so_rcvbuf,
                       Integer netty_io_ratio,
                       Boolean netty_buffer_pooled,
                       Integer netty_buffer_high_watermark,
                       Integer netty_buffer_low_watermark,
                       Boolean netty_epoll,
                       Boolean netty_epoll_lt) {
        this.tcp_nodelay = tcp_nodelay;
        this.tcp_so_reuseaddr = tcp_so_reuseaddr;
        this.tcp_so_backlog = tcp_so_backlog;
        this.tcp_so_keepalive = tcp_so_keepalive;
        this.tcp_so_sndbuf = tcp_so_sndbuf;
        this.tcp_so_rcvbuf = tcp_so_rcvbuf;
        this.netty_io_ratio = netty_io_ratio;
        this.netty_buffer_pooled = netty_buffer_pooled;
        this.netty_buffer_high_watermark = netty_buffer_high_watermark;
        this.netty_buffer_low_watermark = netty_buffer_low_watermark;
        this.netty_epoll = netty_epoll;
        this.netty_epoll_lt = netty_epoll_lt;
    }

    public Boolean isTcp_nodelay() {
        return tcp_nodelay;
    }

    public Boolean isTcp_so_reuseaddr() {
        return tcp_so_reuseaddr;
    }

    public Integer getTcp_so_backlog() {
        return tcp_so_backlog;
    }

    public Boolean getTcp_so_keepalive() {
        return tcp_so_keepalive;
    }

    public Integer getTcp_so_sndbuf() {
        return tcp_so_sndbuf;
    }

    public Integer getTcp_so_rcvbuf() {
        return tcp_so_rcvbuf;
    }

    public Integer getNetty_io_ratio() {
        return netty_io_ratio;
    }

    public Boolean getNetty_buffer_pooled() {
        return netty_buffer_pooled;
    }

    public Integer getNetty_buffer_high_watermark() {
        return netty_buffer_high_watermark;
    }

    public Integer getNetty_buffer_low_watermark() {
        return netty_buffer_low_watermark;
    }

    public Boolean isNetty_epoll() {
        return netty_epoll;
    }

    public Boolean isNetty_epoll_lt() {
        return netty_epoll_lt;
    }

    public static class Builder {
        private Boolean tcp_nodelay = UserConfigDefault.TCP_NODELAY_DEFAULT;

        private Boolean tcp_so_reuseaddr = UserConfigDefault.TCP_SO_REUSEADDR_DEFAULT;

        private Integer tcp_so_backlog = UserConfigDefault.TCP_SO_BACKLOG_DEFAULT;

        private Boolean tcp_so_keepalive = UserConfigDefault.TCP_SO_KEEPALIVE_DEFAULT;

        private Integer tcp_so_sndbuf;

        private Integer tcp_so_rcvbuf;

        private Integer netty_io_ratio = UserConfigDefault.NETTY_IO_RATIO_DEFAULT;

        private Boolean netty_buffer_pooled = UserConfigDefault.NETTY_BUFFER_POOLED_DEFAULT;

        private Integer netty_buffer_high_watermark = UserConfigDefault.NETTY_BUFFER_HIGH_WATERMARK_DEFAULT;

        private Integer netty_buffer_low_watermark = UserConfigDefault.NETTY_BUFFER_LOW_WATERMARK_DEFAULT;

        private Boolean netty_epoll = UserConfigDefault.NETTY_EPOLL_DEFAULT;

        private Boolean netty_epoll_lt = UserConfigDefault.NETTY_EPOLL_LT_DEFAULT;

        public Builder() {
        }

        public Builder setTcp_nodelay(Boolean tcp_nodelay) {
            this.tcp_nodelay = tcp_nodelay;
            return this;
        }

        public Builder setTcp_so_reuseaddr(Boolean tcp_so_reuseaddr) {
            this.tcp_so_reuseaddr = tcp_so_reuseaddr;
            return this;
        }

        public Builder setTcp_so_backlog(Integer tcp_so_backlog) {
            this.tcp_so_backlog = tcp_so_backlog;
            return this;
        }

        public Builder setTcp_so_keepalive(Boolean tcp_so_keepalive) {
            this.tcp_so_keepalive = tcp_so_keepalive;
            return this;
        }

        public Builder setTcp_so_sndbuf(Integer tcp_so_sndbuf) {
            this.tcp_so_sndbuf = tcp_so_sndbuf;
            return this;
        }

        public Builder setTcp_so_rcvbuf(Integer tcp_so_rcvbuf) {
            this.tcp_so_rcvbuf = tcp_so_rcvbuf;
            return this;
        }

        public Builder setNetty_io_ratio(Integer netty_io_ratio) {
            this.netty_io_ratio = netty_io_ratio;
            return this;
        }

        public Builder setNetty_buffer_pooled(Boolean netty_buffer_pooled) {
            this.netty_buffer_pooled = netty_buffer_pooled;
            return this;
        }

        public Builder setNetty_buffer_high_watermark(Integer netty_buffer_high_watermark) {
            this.netty_buffer_high_watermark = netty_buffer_high_watermark;
            return this;
        }

        public Builder setNetty_buffer_low_watermark(Integer netty_buffer_low_watermark) {
            this.netty_buffer_low_watermark = netty_buffer_low_watermark;
            return this;
        }

        public Builder setNetty_epoll(Boolean netty_epoll) {
            this.netty_epoll = netty_epoll;
            return this;
        }

        public Builder setNetty_epoll_lt(Boolean netty_epoll_lt) {
            this.netty_epoll_lt = netty_epoll_lt;
            return this;
        }

        public UserConfig build() {
            return new UserConfig(this.tcp_nodelay,
                    this.tcp_so_reuseaddr,
                    this.tcp_so_backlog,
                    this.tcp_so_keepalive,
                    this.tcp_so_sndbuf,
                    this.tcp_so_rcvbuf,
                    this.netty_io_ratio,
                    this.netty_buffer_pooled,
                    this.netty_buffer_high_watermark,
                    this.netty_buffer_low_watermark,
                    this.netty_epoll,
                    this.netty_epoll_lt);
        }
    }
}
