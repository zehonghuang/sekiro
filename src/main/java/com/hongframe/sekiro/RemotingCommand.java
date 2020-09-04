package com.hongframe.sekiro;

import java.io.Serializable;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 11:51
 */
public interface RemotingCommand extends Serializable {

    ProtocolCode protoVersion();

    CommandCode cmdCode();

    int requestId();

    void serialize();

    void deserialize();

}
