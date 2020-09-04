package com.hongframe.sekiro.demo;

import java.io.Serializable;
import java.util.Random;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 10:55
 */
public class RequestBody implements Serializable {

    private int id;

    /**
     * msg
     */
    private String msg;

    /**
     * body
     */
    private byte[] body;

    private Random r = new Random();

    public RequestBody(int id, int size) {
        this.id = id;
        this.msg = "";
        this.body = new byte[size];
        r.nextBytes(this.body);
    }

}
