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

    private final static byte SEKIRO_PROTOCOL = (byte) 1;

    private CommandEncoder encoder;
    private CommandDecoder decoder;

    public SekiroProtocol() {
        this.encoder = new SekiroCommandEncoder();
        this.decoder = new SekiroCommandDecoder();
    }

    public CommandEncoder encoder() {
        return this.encoder;
    }

    public CommandDecoder decoder() {
        return this.decoder;
    }
}
