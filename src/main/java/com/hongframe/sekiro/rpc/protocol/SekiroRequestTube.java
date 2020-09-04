package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.RemotingCommand;
import com.hongframe.sekiro.RemotingContext;
import com.hongframe.sekiro.RemotingTube;

import java.util.concurrent.ExecutorService;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 20:24
 */
public class SekiroRequestTube<T extends RemotingCommand> implements RemotingTube<T> {
    @Override
    public void process(RemotingContext ctx, T msg, ExecutorService defaultExecutor) throws Exception {

    }

    @Override
    public ExecutorService getExecutor() {
        return null;
    }

    @Override
    public void setExecutor(ExecutorService executor) {

    }
}
