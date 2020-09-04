package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.AbstractLifeCycle;
import com.hongframe.sekiro.BizContext;
import com.hongframe.sekiro.DefaultBizContext;
import com.hongframe.sekiro.RemotingContext;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 14:57
 */
public class AbstractUserTube<T> extends AbstractLifeCycle implements UserTube<T> {
    @Override
    public String identity() {
        return null;
    }

    @Override
    public BizContext preHandleRequest(RemotingContext remotingCtx, T request) {
        return new DefaultBizContext(remotingCtx);
    }

    @Override
    public Object handleRequest(BizContext bizCtx, T request) throws Exception {
        return null;
    }
}
