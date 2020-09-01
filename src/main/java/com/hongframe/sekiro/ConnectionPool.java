package com.hongframe.sekiro;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 墨声 E-mail: zehong.hongframe.huang@gmail.com
 * create time: 2020-09-01 14:44
 */
public class ConnectionPool {

    private List<Connection> connections = new CopyOnWriteArrayList<>();

    private ConnectionSelectStrategy selectStrategy;

    public ConnectionPool(ConnectionSelectStrategy selectStrategy) {
        this.selectStrategy = selectStrategy;
    }

    public void add(Connection connection) {

    }

    public Connection get() {
        if(connections.isEmpty()) {
            return null;
        }

        return selectStrategy.select(new ArrayList<>(connections));
    }

}
