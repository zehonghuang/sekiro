package com.hongframe.sekiro.config;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-01 14:16
 */
public class UserConfig {

    private boolean tcp_nodelay;

    private boolean tcp_so_reuseaddr;

    private int tcp_so_backlo;

    private int tcp_so_keepalive;

    private int tcp_so_sndbuf;

    private int tcp_so_rcvbuf;

    public boolean isTcp_nodelay() {
        return tcp_nodelay;
    }

    public UserConfig setTcp_nodelay(boolean tcp_nodelay) {
        this.tcp_nodelay = tcp_nodelay;
        return this;
    }

    public boolean isTcp_so_reuseaddr() {
        return tcp_so_reuseaddr;
    }

    public UserConfig setTcp_so_reuseaddr(boolean tcp_so_reuseaddr) {
        this.tcp_so_reuseaddr = tcp_so_reuseaddr;
        return this;
    }

    public int getTcp_so_backlo() {
        return tcp_so_backlo;
    }

    public UserConfig setTcp_so_backlo(int tcp_so_backlo) {
        this.tcp_so_backlo = tcp_so_backlo;
        return this;
    }

    public int getTcp_so_keepalive() {
        return tcp_so_keepalive;
    }

    public UserConfig setTcp_so_keepalive(int tcp_so_keepalive) {
        this.tcp_so_keepalive = tcp_so_keepalive;
        return this;
    }

    public int getTcp_so_sndbuf() {
        return tcp_so_sndbuf;
    }

    public UserConfig setTcp_so_sndbuf(int tcp_so_sndbuf) {
        this.tcp_so_sndbuf = tcp_so_sndbuf;
        return this;
    }

    public int getTcp_so_rcvbuf() {
        return tcp_so_rcvbuf;
    }

    public UserConfig setTcp_so_rcvbuf(int tcp_so_rcvbuf) {
        this.tcp_so_rcvbuf = tcp_so_rcvbuf;
        return this;
    }
}
