package com.hongframe.sekiro;

import java.util.Arrays;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 13:26
 */
public class ProtocolCode {

    private byte[] version;

    public ProtocolCode(byte... version) {
        this.version = version;
    }


    public static ProtocolCode fromBytes(byte... version) {
        return new ProtocolCode(version);
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
