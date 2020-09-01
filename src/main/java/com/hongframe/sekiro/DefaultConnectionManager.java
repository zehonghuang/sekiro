package com.hongframe.sekiro;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-08-31 23:43
 */
public class DefaultConnectionManager implements ConnectionManager {

    private ConcurrentHashMap<String, ConnectionPool> pools = new ConcurrentHashMap<>();

    @Override
    public void init() {

    }

    @Override
    public void add(Connection connection) {

    }

    @Override
    public Connection get(String key) {
        return null;
    }

    @Override
    public void remove(String key) {

    }
}
