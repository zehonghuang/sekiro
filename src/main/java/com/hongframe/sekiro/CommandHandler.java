package com.hongframe.sekiro;

import java.util.concurrent.ExecutorService;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 19:43
 */
public interface CommandHandler {

    void handleCommand(RemotingContext ctx, Object msg);

    void registerTube();

    void registerExecutor(ExecutorService executor);

    ExecutorService getExecutor();

}
