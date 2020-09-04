package com.hongframe.sekiro.demo;

import com.hongframe.sekiro.rpc.protocol.AbstractUserTube;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 11:01
 */
public class SimpleServerUserTube extends AbstractUserTube<RequestBody> {
    @Override
    public String identity() {
        return RequestBody.class.getSimpleName();
    }
}
