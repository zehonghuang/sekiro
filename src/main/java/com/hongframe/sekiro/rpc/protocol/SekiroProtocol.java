package com.hongframe.sekiro.rpc.protocol;

import com.hongframe.sekiro.CommandDecoder;
import com.hongframe.sekiro.CommandEncoder;
import com.hongframe.sekiro.Protocol;

/**
 *
 * Request protocol for sekiro
 * 0     1     2           4           6           8          10           12          14          16
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+-----+-----+-----+-----+
 * |proto|p_ver|type | cmdcode   |c_ver|   requestId           |   codec    |   timeout             |
 * +-----------+-----------+-----------+-----------+-----------+------------+-----------+-----------+
 * |classLen   |headerLen  |contentLen             |           ...                                  |
 * +-----------+-----------+-----------+-----------+                                                +
 * |               className + header  + content  bytes                                             |
 * +                                                                                                +
 * |                               ... ...                                                          |
 * +------------------------------------------------------------------------------------------------+
 *
 *
 * Response protocol for sekiro
 * 0     1     2     3     4           6           8          10           12          14          16
 * +-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+-----+------+-----+-----+-----+-----+
 * |proto|p_ver| type| cmdcode   |c_ver|   requestId           |   codec    |respstatus |  classLen |
 * +-----------+-----------+-----------+-----------+-----------+------------+-----------+-----------+
 * |headerLen  | contentLen            |                      ...                                   |
 * +-----------------------------------+                                                            +
 * |               className + header  + content  bytes                                             |
 * +                                                                                                +
 * |                               ... ...                                                          |
 * +------------------------------------------------------------------------------------------------+
 *
 *
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 00:01
 */
public class SekiroProtocol implements Protocol {

    public final static byte SEKIRO_PROTOCOL_CODE = (byte) 1;
    public final static byte SEKIRO_PROTOCOL_VERSION = (byte) 1;

    public final static byte REQUEST_HEADER_LENGTH = 24;
    public final static byte RESPONSE_HEADER_LENGTH = 22;

    private CommandEncoder encoder;
    private CommandDecoder decoder;

    public SekiroProtocol() {
        this.encoder = new SekiroCommandEncoder();
        this.decoder = new SekiroCommandDecoder();
    }

    @Override
    public CommandEncoder encoder() {
        return this.encoder;
    }

    @Override
    public CommandDecoder decoder() {
        return this.decoder;
    }
}
