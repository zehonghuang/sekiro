package com.hongframe.sekiro.rpc.cmd;

import com.hongframe.sekiro.rpc.cmd.SekiroCommand;
import com.hongframe.sekiro.rpc.cmd.SekiroCommandType;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 14:00
 */
public class SekiroRequestCommand extends SekiroCommand {

    private int timeout = -1;

    public SekiroRequestCommand() {
        super(SekiroCommandType.REQUEST);
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
