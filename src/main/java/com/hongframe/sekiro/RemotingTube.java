package com.hongframe.sekiro;

import java.util.concurrent.ExecutorService;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 23:18
 */
public interface RemotingTube<T extends RemotingCommand> {

    void process(RemotingContext ctx, T msg, ExecutorService defaultExecutor) throws Exception;

    ExecutorService getExecutor();

    void setExecutor(ExecutorService executor);

}
