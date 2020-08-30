package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 18:37
 */
public interface RemotingServer extends LifeCycle {

    String ip();

    int port();

}
