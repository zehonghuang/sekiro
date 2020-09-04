package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-03 20:11
 */
public interface CommandFactory {

    <T extends RemotingCommand> T request(final Object request);

    <T extends RemotingCommand> T response(final Object response,
                                           RemotingCommand request);

}
