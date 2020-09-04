package com.hongframe.sekiro.rpc;

import com.hongframe.sekiro.CommandHandler;
import com.hongframe.sekiro.RemotingContext;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 19:59
 */
public class SekiroCommandHandler implements CommandHandler {
    @Override
    public void handleCommand(RemotingContext ctx, Object msg) {
        if(msg instanceof List) {

        } else {

        }
    }

    @Override
    public void registerTube() {

    }

    @Override
    public void registerExecutor(ExecutorService executor) {

    }

    @Override
    public ExecutorService getExecutor() {
        return null;
    }
}
