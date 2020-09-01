package com.hongframe.sekiro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 23:06
 */
public class ProtocolManager {

    private static final Logger logger = LoggerFactory.getLogger(ProtocolManager.class);

    private static final ConcurrentMap<ProtocolCode, Protocol> protocols = new ConcurrentHashMap<ProtocolCode, Protocol>();

    public static Protocol getProtocol(ProtocolCode protocolCode) {
        return protocols.get(protocolCode);
    }


    public static void registerProtocol(Protocol protocol, ProtocolCode protocolCode) {
        if(Objects.isNull(protocol) || Objects.isNull(protocolCode)) {
            throw new IllegalArgumentException("Protocol and ProtocolCode should not be null!");
        }
        Protocol exists = ProtocolManager.protocols.putIfAbsent(protocolCode, protocol);
        if(Objects.nonNull(exists)) {
            logger.warn("Protocol for code: " + protocolCode + " already exists!");
        }
    }

}
