package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-04 11:11
 */
public interface BizContext {

    Connection getConnection();

    int getClientTimeout();

    void put(String key, String value);

    String get(String key);

}
