package com.hongframe.sekiro.rpc.cmd;

import com.hongframe.sekiro.CommandCode;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 11:52
 */
public enum SekiroCommandCode implements CommandCode {

    REQUEST((short) 1), RESPONSE((short) 2)
    ;

    private short code;

    SekiroCommandCode(short code) {
        this.code = code;
    }

    @Override
    public short code() {
        return this.code;
    }

    public static SekiroCommandCode valueOf(short code) {
        switch (code) {
            case (short) 1: return REQUEST;
            case (short) 2: return RESPONSE;
        }
        throw new IllegalArgumentException("Unkown this command code: " + code);
    }
}
