package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 14:09
 */
public enum ResponseStatus {

    SUCCESS((short) 0X0000),
    ERROR((short) 0X0001),
    TIMEOUT((short) 0X0002),
    ;

    private short status;

    ResponseStatus(short status) {
        this.status = status;
    }

    public short status() {
        return status;
    }

    public static ResponseStatus valueOf(short value) {
        switch (value) {
            case 0x0000:
                return SUCCESS;
            case 0x0001:
                return ERROR;
        }
        throw new IllegalArgumentException("Unknown status value ," + value);
    }
}
