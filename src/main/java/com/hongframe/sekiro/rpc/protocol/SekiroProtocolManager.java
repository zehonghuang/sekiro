package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.ProtocolCode;
import com.hongframe.sekiro.ProtocolManager;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 23:38
 */
public class SekiroProtocolManager {

    public static void initProtocols() {
        ProtocolManager.registerProtocol(new SekiroProtocol(), ProtocolCode.fromBytes(SekiroProtocol.SEKIRO_PROTOCOL_CODE));
    }

}
