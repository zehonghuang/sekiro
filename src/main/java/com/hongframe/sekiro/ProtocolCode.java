package com.hongframe.sekiro;

import java.util.Arrays;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 13:26
 */
public class ProtocolCode {

    private byte[] version;

    public ProtocolCode(byte... code) {
        this.version = code;
    }


    public static ProtocolCode fromBytes(byte... code) {
        return new ProtocolCode(code);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProtocolCode that = (ProtocolCode) o;
        return Arrays.equals(version, that.version);
    }

}
