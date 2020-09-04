package com.hongframe.sekiro.rpc.cmd;

import com.hongframe.sekiro.CommandFactory;
import com.hongframe.sekiro.RemotingCommand;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 20:13
 */
public class SekiroCommandFactory implements CommandFactory {
    @Override
    public SekiroRequestCommand request(Object request) {
        return new SekiroRequestCommand(request);
    }

    @Override
    public SekiroResponseCommand response(Object response, RemotingCommand request) {
        return new SekiroResponseCommand(response);
    }
}
