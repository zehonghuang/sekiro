package com.hongframe.sekiro;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-30 21:57
 */
public interface ConnectionManager {

    void init();

    void add(Connection connection);

    Connection get(String key);

    void remove(String key);
}
