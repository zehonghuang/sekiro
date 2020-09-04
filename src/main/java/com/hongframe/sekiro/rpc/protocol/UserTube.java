package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.BizContext;
import com.hongframe.sekiro.LifeCycle;
import com.hongframe.sekiro.RemotingContext;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 19:38
 */
public interface UserTube<T> extends LifeCycle {

    String identity();

    BizContext preHandleRequest(RemotingContext remotingCtx, T request);

    Object handleRequest(BizContext bizCtx, T request) throws Exception;

}
